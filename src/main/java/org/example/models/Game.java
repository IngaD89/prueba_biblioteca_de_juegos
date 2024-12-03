package org.example.models;

public class Game {
    private int id;
    static private int incrementedId = 0;
    private String name;
    private DifficultyLevel difficulty;
    private GameType gameType;
    private double price;
    private final int IVA = 10;

    public Game(String name, DifficultyLevel difficulty, GameType gameType, double price) {
        this.id = incrementedId;
        incrementedId = ++this.id;
        this.name = name;
        this.difficulty = difficulty;
        this.gameType = gameType;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public double totalPrice() {
        double totalPrice = 0;
        totalPrice = this.price + ((this.price * this.IVA) / 100);
        return totalPrice;
    }


    @Override
    public String toString() {
        return "Game{" +
                "id = " + this.id +
                ", name = '" + this.name + '\'' +
                ", difficulty = " + this.difficulty +
                ", game type = " + this.gameType +
                ", price = " + this.price +
                ", IVA = " + this.IVA +
                ", total price =" + this.totalPrice() +
                '}';
    }
}
