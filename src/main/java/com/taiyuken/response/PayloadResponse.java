package com.taiyuken.response;

public class PayloadResponse {
    private String status;
    private Object payload;

    public PayloadResponse(String status, Object payload){
        this.status = status;
        this.payload = payload;
    }

    public String getStatus(){
        return this.status;
    }

    public Object getPayload(){
        return this.payload;
    }
}
