package org.example.exception;

public class GameAlreadyExistsException extends Exception{
    public GameAlreadyExistsException() {
        super("Game already exists");
    }
}
