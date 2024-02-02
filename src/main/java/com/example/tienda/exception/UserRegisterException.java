package com.example.tienda.exception;

public class UserRegisterException extends RuntimeException{
    public UserRegisterException() {
    }

    public UserRegisterException(String message) {
        super(message);
    }
}
