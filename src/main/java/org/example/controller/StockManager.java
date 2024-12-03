package org.example.controller;

import org.example.exception.GameAlreadyExistsException;
import org.example.exception.GameNotFoundException;
import org.example.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockManager {

    private final Scanner scanner = new Scanner(System.in);
    private final List<Game> gameList = new ArrayList<>();

    private String name;
    private DifficultyLevel level;
    private double price;

    private void dataRequest() {

        System.out.println("Introduce nombre de juego");
        name = scanner.nextLine();

        System.out.println("Introduce dificultad, escoge entre: EASY, NORMAL, HARD");
        level = DifficultyLevel.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Introduce precio sin IVA");
        price = scanner.nextDouble();
        scanner.nextLine();
    }


    public void createGame() throws GameAlreadyExistsException {
        int option = 0;


        System.out.println("""
                Escoge tipo de juego:
                1. Strategy
                2. Gambling
                3. Role-Playing
                """);

        option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {

            case 1:

                dataRequest();

                for (Game game : gameList) {
                    if (game.getName().equalsIgnoreCase(name)) {
                        throw new GameAlreadyExistsException();
                    }
                }

                Game strategy = new Strategy(name, level, price);
                gameList.add(strategy);
                System.out.println("El juego " + strategy.getName() + " Creado satisfactoriamnte");
                break;

            case 2:

                dataRequest();
                for (Game game : gameList) {
                    if (game.getName().equalsIgnoreCase(name)) {
                        throw new GameAlreadyExistsException();
                    }
                }
                Game gambling = new Gambling(name, level, price);
                gameList.add(gambling);
                System.out.println("El juego " + gambling.getName() + " Creado satisfactoriamnte");
                break;

            case 3:

                dataRequest();
                for (Game game : gameList) {
                    if (game.getName().equalsIgnoreCase(name)) {
                        throw new GameAlreadyExistsException();
                    }
                }
                Game rolePlaying = new RolePlaying(name, level, price);
                gameList.add(rolePlaying);
                System.out.println("El juego " + rolePlaying.getName() + " Creado satisfactoriamnte");
                break;

            default:
                System.out.println("Escoge una opción válida");
        }

    }

    public void getAllGames() {
        for (Game game : gameList) {
            System.out.println(game);
        }
    }

    public void getGameByName() throws GameNotFoundException {
        String name;
        System.out.println("Introduce nombre de juego que queres buscar");
        name = scanner.nextLine();

        for (Game game : gameList) {
            if (!game.getName().equalsIgnoreCase(name)) {
                throw new GameNotFoundException("Juego con nombre " + name + " no se ha encontrado");
            } else {
                System.out.println(game);
            }
        }
    }

    public void deleteGameByName() throws GameNotFoundException {
        String name;
        System.out.println("Introduce nombre de juego que queres buscar");
        name = scanner.nextLine();

        for (Game game : gameList) {
            if (!game.getName().equalsIgnoreCase(name)) {
                throw new GameNotFoundException("Juego con nombre " + name + " no se ha encontrado");
            } else {
                gameList.remove(game);
                System.out.println("Juego " + game.getName() + " Borrado satisfactoriamente");
            }
        }
    }

    public void filterByLevel(){

        System.out.println("Introduce dificultad para filtrar, escoge entre: EASY, NORMAL, HARD");
        level = DifficultyLevel.valueOf(scanner.nextLine().toUpperCase());

        gameList
                .stream()
                .filter(game -> game.getDifficulty().equals(level))
                .forEach(System.out::println);
    }

    public void filterByCategory() {
        GameType type;

        System.out.println("Introduce categoria para filtrar, escoge entre: Strategy, Gambling, Role-playing");
        type = GameType.valueOf(scanner.nextLine().toUpperCase());

        gameList
                .stream()
                .filter(game -> game.getGameType().equals(type))
                .forEach(System.out::println);
    }
}