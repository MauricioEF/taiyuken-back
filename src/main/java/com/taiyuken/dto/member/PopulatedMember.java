package com.taiyuken.dto.member;

import com.taiyuken.model.BoardGame;
import com.taiyuken.model.VideoGame;

public class PopulatedMember {
    private int id;
    private String nickname;
    private String description;
    private String platform;
    private VideoGame favoriteVideoGame;
    private BoardGame favoriteBoardGame;


    public int getId() {
        return this.id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPlatform() {
        return this.platform;
    }

    public VideoGame getFavoriteVideoGame() {
        return this.favoriteVideoGame;
    }

    public BoardGame getFavoriteBoardGame() {
        return this.favoriteBoardGame;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setFavoriteVideoGame(VideoGame favoriteVideoGame) {
        this.favoriteVideoGame = favoriteVideoGame;
    }

    public void setFavoriteBoardGame(BoardGame favoriteBoardGame) {
        this.favoriteBoardGame = favoriteBoardGame;
    }
}
