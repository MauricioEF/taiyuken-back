package com.taiyuken.dto.videoGame;

public class CreateVideoGameRequest {
    private String title;
    private String description;

    public CreateVideoGameRequest(){}

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}
