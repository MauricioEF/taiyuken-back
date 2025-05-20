package com.taiyuken.model;

public class BoardGame {
    private int id;
    private String title;
    private String description;
    private String type;
    private String image;

    public BoardGame(int id, String title, String description, String type, String image){
        this.id=id;
        this.title=title;
        this.description=description;
        this.type=type;
        this.image=image;
    }

    public int getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String getType(){
        return this.type;
    }

    public String getImage(){
        return this.image;
    }
}
