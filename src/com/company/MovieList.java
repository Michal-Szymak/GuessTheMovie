package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieList {

    private ArrayList<String> titles;

    public MovieList(String filename) throws Exception{
        this.titles = new ArrayList<>();

        File file = new File(filename);
        Scanner scanner = null;

        try{
                scanner = new Scanner(file);
        }
        catch (Exception e){
            System.out.println("Specified file does not exist.");
            System.exit(2);
        }

        //Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            this.titles.add(scanner.nextLine());
        }

    }

    public String getRandomTitle(){
        int titleIndex = (int) (Math.random() * this.titles.size());
        return this.titles.get(titleIndex);
    }


}
