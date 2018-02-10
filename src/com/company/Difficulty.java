package com.company;

import java.util.Scanner;

public class Difficulty {

    //Default constructor
    public void Difficulty() {}


    /**
     This method handles the difficulty. it has no input parameter.
     It is declared static because it does not need an object instance.
     It asks the user to choose the difficulty by selection a number between 1 and 3.
     @return an int which is the number of tries the user get based on their difficulty selection
     the default value (in case they choose something other their options is 5 tries (moderate difficulty)
     */
    public static int getDifficulty() {
        System.out.println("Enter a number between 1 and 3");
        Scanner scanner = new Scanner(System.in);
        String difficulty = scanner.nextLine();
        int difficultyInput = Integer.parseInt(difficulty);
        int numTry;
        switch (difficultyInput) {
            case 1:
                numTry = 3;
                break;
            case 2:
                numTry = 5;
                break;
            case 3:
                numTry = 7;
                break;
            default:
                numTry = 5;
                break;
        }
        return numTry;
    }

}
