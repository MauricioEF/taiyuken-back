package com.taiyuken.model;

public class Member {
    private int id;
    private String nickname;
    private String description;
    private String platform;
    private int favoriteVideoGame;
    private int favoriteBoardGame;

    public Member(int id, String nickname, String description, String platform, int favoriteVideoGame, int favoriteBoardGame) {
        this.id = id;
        this.nickname = nickname;
        this.description = description;
        this.platform = platform;
        this.favoriteVideoGame = favoriteVideoGame;
        this.favoriteBoardGame = favoriteBoardGame;
    }

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

    public int getFavoriteVideoGame() {
        return this.favoriteVideoGame;
    }

    public int getFavoriteBoardGame() {
        return this.favoriteBoardGame;
    }


}
