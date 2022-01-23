package com.example.crud.exeption;

public class UserAlreadyExistExeption extends Exception{
    public UserAlreadyExistExeption(String message) {
        super(message);
    }
}
