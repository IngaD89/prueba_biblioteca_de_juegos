package org.example.controller;

import org.example.exception.GameAlreadyExistsException;
import org.example.exception.GameNotFoundException;

import java.util.Scanner;

public class MenuHandler {

    private final Scanner scanner = new Scanner(System.in);
    private final StockManager manager = new StockManager();


    public void run(){
        int option;

        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            getOption(option);
        } while (option != 0);
    }


    private void menu(){
        System.out.println("""
                Escoge una opción:
                0. salir de programa
                1. Crear nuevo juego
                2. Mostrar juegos
                3. Mostrar un juego dado su nombre
                4. Eliminar un juego dado su nombre
                5. Filtrar juegos por dificultad
                6. Filtrar juegos por categoria
                """);
    }

    private int getOption(int option){
        switch (option){

            case 0 -> System.out.println("Hasta pronto");
            case 1 -> {
                try {
                    manager.createGame();
                } catch (GameAlreadyExistsException e) {
                    System.out.println("Game already exists " + e.getMessage());
                }
            }
            case 2 -> manager.getAllGames();
            case 3 -> {
                try{
                    manager.getGameByName();
                }catch (GameNotFoundException e){
                    System.out.println(e.getMessage());
                }
            }
            case 4 -> {
                try {
                    manager.deleteGameByName();
                } catch (GameNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 5 -> manager.filterByLevel();
            case 6 -> manager.filterByCategory();
            default -> System.out.println("Escoge una opción válida");

        }
        return option;
    }
}
