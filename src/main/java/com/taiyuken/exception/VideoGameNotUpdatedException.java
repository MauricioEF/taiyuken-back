package com.taiyuken.exception;

public class VideoGameNotUpdatedException extends RuntimeException {
    public VideoGameNotUpdatedException(String message){
        super(message);
    }
}
