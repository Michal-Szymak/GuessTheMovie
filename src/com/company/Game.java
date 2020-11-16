package com.company;

public class Game {
    private String hiddenTitle;
    private char[] displayedTitle;
    private String correctLetters = new String();
    private String wrongLetters = new String();
    int mistakes = 0;

    public Game(String movieTitle){
        this.hiddenTitle = movieTitle;
        this.displayedTitle = new char[movieTitle.length()];
        for(int i = 0; i < movieTitle.length(); i++){
            displayedTitle[i] = '_';

        }
    }


    public void checkLetter(char letter){
        if(wrongLetters.indexOf(letter) != -1 || correctLetters.indexOf(letter) != -1){
            System.out.println("You have guessed that letter before, try again");
        }
        else if(this.hiddenTitle.indexOf(letter) == -1){
            this.mistakes++;
            this.wrongLetters += " " + letter;
        } else {
            this.correctLetters += letter;
            int letterIndex = this.hiddenTitle.indexOf(letter);
            while(letterIndex != -1){
                displayedTitle[letterIndex] = letter;
                letterIndex = this.hiddenTitle.indexOf(letter, letterIndex + 1);
            }
        }
    }

    public void displayStatus(){
        System.out.print("You are guessing:");
        System.out.println(this.displayedTitle);
        System.out.println("You have guessed (" + this.mistakes + ") wrong letters: " + this.wrongLetters);
    }

    public boolean checkEndgameConditions(){
        if(mistakes == 10){
            System.out.println("You have reached a limit of wrong letters. Game over.");
            System.out.println("Title you were trying to guess is: " + this.hiddenTitle);
            return true;
        }
        for(int i = 0; i < this.displayedTitle.length; i++){
            if( this.displayedTitle[i] == '_' && String.valueOf(this.hiddenTitle.charAt(i)).matches("[a-zA-z]") ){
                return false;
            }
        }

        System.out.println("You win!\nYou have guessed '" + this.hiddenTitle + "' correctly.");
        return true;
    }
}
