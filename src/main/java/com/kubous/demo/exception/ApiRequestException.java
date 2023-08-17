package com.kubous.demo.exception;

public class ApiRequestException extends RuntimeException{
    //this is what we are going to throw from our code
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
