package com.taiyuken.dto.videoGame;

import jakarta.validation.constraints.NotBlank;

public class UpdateVideoGameRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
