package com.taiyuken.service;

import com.taiyuken.dto.videoGame.CreateVideoGameRequest;
import com.taiyuken.exception.VideoGameNotFoundException;
import com.taiyuken.model.VideoGame;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VideoGameService {
    //Mock
    private final List<VideoGame> videoGames = new ArrayList<>(List.of(
            new VideoGame(1, "Stardew valley","Plantar plantitas plantosas"),
            new VideoGame(2, "Left 4 dead","matar zombies y a tus compis"),
            new VideoGame(3, "Fortnite","Esconderte y ser gay si no sacas tus kills"),
            new VideoGame(4, "Rocket League","What a save"),
            new VideoGame(5,"Gang Beasts","Perrazos en 3D")
    ));

    public List<VideoGame>getVideoGames(){
        return videoGames;
    }

    public VideoGame getVideoGameOrFail(int id){
        Optional<VideoGame> optionalVideoGame = getVideoGameById(id);
        if(optionalVideoGame.isEmpty()){
            throw new VideoGameNotFoundException("VideoGame not found");
        }
        return optionalVideoGame.get();
//        return videoGames.stream().filter(videoGame -> videoGame.getId() == id).findFirst().orElseThrow(()-> new VideoGameNotFoundException("VideoGame not found"));
    }

    public Optional<VideoGame> getVideoGameById(int id){
        for(VideoGame videoGame : videoGames){
            if(videoGame.getId()==id){
                return Optional.of(videoGame);
            }
        }
        return Optional.empty();
        //return videoGames.stream().filter(videoGame -> videoGame.getId()==id).findFirst();
    }

    public VideoGame createVideoGame(CreateVideoGameRequest request){
        int id = videoGames.size()+1;
        VideoGame videoGame = new VideoGame(id,request.getTitle(),request.getDescription());
        videoGames.add(videoGame);
        return videoGame;
    }
}
