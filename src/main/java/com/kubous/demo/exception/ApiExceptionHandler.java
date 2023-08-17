package com.kubous.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
//handles the exceptions
public class ApiExceptionHandler {
    //this is used to build a response to our client
    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(
            //take an exception it's going to handle
            ApiRequestException e
    ) {
        //built's the payload for our client
        ApiException apiException = new ApiException(
                e.getMessage(), e, HttpStatus.BAD_REQUEST, ZonedDateTime.now()
        );
        //send response using ResponseEntity
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(
            //take an exception it's going to handle
            NotFoundException e
    ) {
        //built's the payload for our client
        ApiException apiException = new ApiException(
                e.getMessage(), e, HttpStatus.NOT_FOUND, ZonedDateTime.now()
        );
        //send response using ResponseEntity
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
