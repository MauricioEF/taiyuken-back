package com.taiyuken.controller;

import com.taiyuken.model.VideoGame;
import com.taiyuken.response.PayloadResponse;
import com.taiyuken.service.VideoGameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{videoGameId}")
    public ResponseEntity<Object> getVideoGameById(@PathVariable("videoGameId") int videoGameId){
        return ResponseEntity.status(HttpStatus.OK).body(new PayloadResponse("success",this.videoGameService.getVideoGameOrFail(videoGameId)));
    }
}
