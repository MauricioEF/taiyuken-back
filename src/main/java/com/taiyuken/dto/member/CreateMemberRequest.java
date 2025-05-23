package com.taiyuken.dto.member;

public class CreateMemberRequest {
    private String nickname;
    private String description;
    private String platform;
    private int favoriteVideoGame;
    private int favoriteBoardGame;

    public CreateMemberRequest(){}

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getFavoriteVideoGame() {
        return favoriteVideoGame;
    }

    public void setFavoriteVideoGame(int favoriteVideoGame) {
        this.favoriteVideoGame = favoriteVideoGame;
    }

    public int getFavoriteBoardGame() {
        return favoriteBoardGame;
    }

    public void setFavoriteBoardGame(int favoriteBoardGame) {
        this.favoriteBoardGame = favoriteBoardGame;
    }
}
