package com.taiyuken.response;

public class MessageResponse {
    private String status;
    private String message;

    public MessageResponse(String status, String message){
        this.status = status;
        this.message = message;
    }

    public String getStatus(){
        return this.status;
    }

    public String getMessage(){
        return this.message;
    }
}
