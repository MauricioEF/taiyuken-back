package com.taiyuken.dto.boardGame;

public class CreateBoardGameRequest {
    private String title;
    private String description;
    private String type;
    private String image;

    public CreateBoardGameRequest(){}

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type=type;
    }

    public String getImage(){
        return this.image;
    }

    public void setImage(String image){
        this.image=image;
    }
}
