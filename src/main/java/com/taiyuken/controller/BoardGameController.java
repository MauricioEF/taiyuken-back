package com.taiyuken.controller;

import com.taiyuken.dto.boardGame.CreateBoardGameRequest;
import com.taiyuken.model.BoardGame;
import com.taiyuken.response.MessageResponse;
import com.taiyuken.response.PayloadResponse;
import com.taiyuken.service.BoardGameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/boardgames")
public class BoardGameController {
    private final BoardGameService boardGameService;

    public BoardGameController(BoardGameService boardGameService){
        this.boardGameService = boardGameService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllBoardGames(){
        List<BoardGame> boardgames = this.boardGameService.getAllBoardGames();
        return ResponseEntity.status(HttpStatus.OK).body(new PayloadResponse("success",boardgames));
    }

    @PostMapping
    public ResponseEntity<Object> createBoardGame(@RequestParam("image") MultipartFile boardGameImage, @ModelAttribute CreateBoardGameRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("success","Endpoint in construction"));
    }
}
