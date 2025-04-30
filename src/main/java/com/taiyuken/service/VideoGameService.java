package com.taiyuken.service;

import com.taiyuken.exception.VideoGameNotFoundException;
import com.taiyuken.model.VideoGame;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoGameService {
    //Mock
    private static final List<VideoGame> videoGames = List.of(
            new VideoGame(1, "Stardew valley","Plantar plantitas plantosas"),
            new VideoGame(2, "Left 4 dead","matar zombies y a tus compis"),
            new VideoGame(3, "Fortnite","Esconderte y ser gay si no sacas tus kills"),
            new VideoGame(4, "Rocket League","What a save"),
            new VideoGame(5,"Gang Beasts","Perrazos en 3D")
    );

    public List<VideoGame>getVideoGames(){
        return videoGames;
    }

    public VideoGame getVideoGameOrFail(int id){
        return videoGames.stream().filter(videoGame -> videoGame.getId() == id).findFirst().orElseThrow(()-> new VideoGameNotFoundException("VideoGame not found"));
    }
    public Optional<VideoGame> getVideoGameById(int id){
        return videoGames.stream().filter(videoGame -> videoGame.getId()==id).findFirst();
    }
}
