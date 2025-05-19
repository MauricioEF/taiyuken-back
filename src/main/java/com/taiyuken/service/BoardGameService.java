package com.taiyuken.service;

import com.taiyuken.dto.boardGame.CreateBoardGameRequest;
import com.taiyuken.exception.BoardGameNotFoundException;
import com.taiyuken.model.BoardGame;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardGameService {
    private final List<BoardGame> boardGames = new ArrayList<>();

    public BoardGameService(){}

    public List<BoardGame> getAllBoardGames(){
        return this.boardGames;
    }

    public BoardGame getBoardGameByIdOrFail(int id) {
        for (BoardGame boardGame : boardGames) {
            if (boardGame.getId() == id) {
                return boardGame;
            }
        }
        throw new BoardGameNotFoundException("Board game not found");
    }
    public BoardGame createBoardGame(CreateBoardGameRequest request){
        int id;
        BoardGame lastBoardGameAdded = boardGames.getLast();
        if(lastBoardGameAdded==null) {
            id = 1;
        }else{
            id = lastBoardGameAdded.getId()+1;
        }
        BoardGame boardGameToCreate = new BoardGame(id,request.getTitle(),request.getDescription(),request.getType(),request.getImage());
        boardGames.add(boardGameToCreate);
        return boardGameToCreate;
    }
}
