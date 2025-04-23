package com.taiyuken.service;

import com.taiyuken.model.VideoGame;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoGameService {
    //Mock
    private static final List<VideoGame> videoGames = List.of(
            new VideoGame(1, "Stardew valley","Plantar plantitas plantosas"),
            new VideoGame(2, "Left 4 dead","matar zombies y a tus compis"),
            new VideoGame(3, "Fortnite","Esconderte y ser gay si no sacas tus kills")
    );

    public List<VideoGame>getVideoGames(){
        return videoGames;
    }
}
