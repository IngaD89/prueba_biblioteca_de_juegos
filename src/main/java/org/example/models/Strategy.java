package org.example.models;

public class Strategy extends Game{

    public Strategy(String name, DifficultyLevel difficulty, double price) {
        super( name, difficulty, GameType.STRATEGY, price);
    }

}
