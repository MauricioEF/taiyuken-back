package com.taiyuken.controller;

import com.taiyuken.dto.videoGame.CreateVideoGameRequest;
import com.taiyuken.dto.videoGame.UpdateVideoGameRequest;
import com.taiyuken.model.VideoGame;
import com.taiyuken.response.MessageResponse;
import com.taiyuken.response.PayloadResponse;
import com.taiyuken.service.VideoGameService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videogames")//api/videogames
public class VideoGameController {

    private final VideoGameService videoGameService;

    public VideoGameController(VideoGameService videoGameService){
        this.videoGameService = videoGameService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllVideoGames(){
        //Devolver Videojuegos
        List<VideoGame> videoGames = this.videoGameService.getVideoGames();
        return ResponseEntity.status(HttpStatus.OK).body(new PayloadResponse("success",videoGames));
    }

    @PostMapping
    public ResponseEntity<Object> createVideoGame(@RequestBody CreateVideoGameRequest request){
        System.out.println("ENTRE");
        if(request.getTitle()==null||request.getDescription()==null){
            return ResponseEntity.badRequest().body(new MessageResponse("error","Incomplete values"));
        }
        VideoGame videoGame = this.videoGameService.createVideoGame(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PayloadResponse("success",videoGame));
    }

    @GetMapping("/{videoGameId}")
    public ResponseEntity<Object> getVideoGameById(@PathVariable("videoGameId") int videoGameId){
        return ResponseEntity.status(HttpStatus.OK).body(new PayloadResponse("success",this.videoGameService.getVideoGameOrFail(videoGameId)));
    }

    @PutMapping("/{videoGameId}")
    public ResponseEntity<Object> updateVideoGame(@PathVariable int videoGameId, @Valid @RequestBody
    UpdateVideoGameRequest videoGameRequest){
        return ResponseEntity.status(HttpStatus.OK).body(new PayloadResponse("success",this.videoGameService.updateVideoGame(videoGameId,videoGameRequest)));
    }
}
