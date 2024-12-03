package org.example.models;

public class RolePlaying extends Game{
    public RolePlaying(String name, DifficultyLevel difficulty, double price) {
        super(name, difficulty, GameType.ROLE_PLAYING, price);
    }
}
