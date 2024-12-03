package org.example.models;

public class Gambling extends Game{

    public Gambling(String name, DifficultyLevel difficulty, double price) {
        super(name, difficulty, GameType.GAMBLING, price);
    }

}
