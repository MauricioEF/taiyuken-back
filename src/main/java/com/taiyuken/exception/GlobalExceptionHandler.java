package com.taiyuken.exception;

import com.taiyuken.response.MessageResponse;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

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

    @ExceptionHandler(BoardGameNotFoundException.class)
    public ResponseEntity<MessageResponse> handleBoardGameNotFound(BoardGameNotFoundException exception){
        return new ResponseEntity<>(new MessageResponse("error",exception.getMessage()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<MessageResponse> handleBoardGameNotFound(MemberNotFoundException exception){
        return new ResponseEntity<>(new MessageResponse("error", exception.getMessage()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VideoGameNotUpdatedException.class)
    public ResponseEntity<MessageResponse> handleVideoGameNotUpdated(VideoGameNotUpdatedException exception){
        return new ResponseEntity<>(new MessageResponse("error",exception.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageResponse> handleMethodArgumentNotvalid(MethodArgumentNotValidException ex){
        System.out.println(ex.getFieldErrors());
        String message = String.format("Validation error for field: %s: %s", Objects.requireNonNull(ex.getFieldError()).getField(),ex.getFieldError().getRejectedValue());
        return new ResponseEntity<>(new MessageResponse("error",message),HttpStatus.BAD_REQUEST);
    }
}
