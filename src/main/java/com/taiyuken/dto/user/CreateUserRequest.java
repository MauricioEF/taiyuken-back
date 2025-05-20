package com.taiyuken.dto.user;

public class CreateUserRequest {
    private String name;
    private String username;
    private String email;

    public CreateUserRequest (){}


    public String getName(){
        return this.name;
    }
    public String getUsername(){
        return this.username;
    }
    public String getEmail(){
        return this.email;
    }


    public void setName (String name){
        this.name = name;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setEmail(String email){
        this.email = email;
    }
}

