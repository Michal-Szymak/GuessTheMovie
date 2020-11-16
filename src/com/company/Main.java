package com.company;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        MovieList movieList = new MovieList("movies.txt");
        Game game = new Game(movieList.getRandomTitle());

        while(!game.checkEndgameConditions()){
            game.displayStatus();
            System.out.print("Guess a letter: ");
            String input = scanner.nextLine();
            while(!input.matches("[a-zA-Z]")){
                System.out.println("Please type in a single letter, try again.");
                input = scanner.nextLine();
            }
            game.checkLetter(input.toLowerCase().charAt(0));
        }

    }
}
