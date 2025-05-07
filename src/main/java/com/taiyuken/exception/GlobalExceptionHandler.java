package com.taiyuken.exception;

import com.taiyuken.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VideoGameNotFoundException.class)
    public ResponseEntity<MessageResponse> handleVideoGameNotFound(VideoGameNotFoundException exception){
        return new ResponseEntity<>(new MessageResponse("error",exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<MessageResponse> handleUserNotFound(UserNotFoundException exception){
        return new ResponseEntity<>(new MessageResponse("error",exception.getMessage()), HttpStatus.NOT_FOUND);
    }

}
