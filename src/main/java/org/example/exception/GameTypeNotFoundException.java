package org.example.exception;

public class GameTypeNotFoundException extends Exception{
    public GameTypeNotFoundException() {
        super("Game type not found exception");
    }
}
