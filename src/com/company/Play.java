package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *      This class is responsible for handling all the game play.
 *
 */

public class Play {

    //variables
    private static int i, x, y, coori, coorj, b1x, b1y, b2x, b2y, b3x, b3y;
    private static Scanner scanner = new Scanner(System.in);
    private static char[][] fieldArray;
    private static ArrayList<Bomb> bombArray = new ArrayList<>();


    //DEFAULT CONSTRUCTOR
    Play(){}

    /**
     *  This is the main method which references the more detailed gameplay methods based on the number
     *  of the bomb that the user has selected
     *
     */
    public static void play() {
        int size, bombSize;
        Scanner scanner = new Scanner(System.in);
        Main.print("\nThe game is a Battleship simulator.\nTry to guess the bomb location" +
                " in as little tries as possible to win.\nEnter the location by giving the x-coordinate, followed by" +
                " the y-coordante, separated by \" , \"");
        Main.print("\nPlease enter the size of the matrix (i.e. number of rows)");
        size = scanner.nextInt();
        //checks to make sure the matrix is between 2 and 10
        while (size<2 || size>10) {
            Main.print("Invalid entry. Enter a number between 2 and 10");
            size = scanner.nextInt();
        } //while
        Main.print("Please enter the number of bombs to be created (1, 2, or 3)");
        bombSize = scanner.nextInt();
        //Checks to makee sure your bombSize size is smaller than the size of the matrix
        while (bombSize >= size || bombSize > 3) {
            Main.print("Invalid entry. Please enter a number between 1 and 3)" +
                    "\nPlease enter the number of bombs to be created");
            bombSize = scanner.nextInt();
        } //while
        //Get the difficulty
        final int numTry= Difficulty.getDifficulty();

        //Directing to different methods based on teh bombsize
        switch (bombSize) {
            //Playing a game with one bomb
            case 1:
                play1(size, numTry);
                break;
            //Playing a game with one, 2-grid bomb
            case 2:
                play2(size, numTry);
                break;
            //Playing a game with one, 3-point bomb
                case 3:
                    play3(size, numTry);
                    break;
        } //switch


    } //play method


    private static void play1(int size, int numTry) {

        //variables
        Bomb bomb = new Bomb();
        fieldArray = new char[size][size];
        //get the bomb coordinates from bomb1 method of Bomb class
        bombArray = bomb.bomb2L(size);
        b1x = bombArray.get(0).x;
        b1y = bombArray.get(0).y;
        //create our initial matrix
        fieldArray = Main.populateArray('-', fieldArray.length);
        Main.print2DArray(fieldArray, fieldArray.length);

        for (i = numTry; i > 0; i--) {

            Main.print("\nYou have " + i + " tries left.");
            Main.print("Please enter the coordinates in the form \"x,y\" with no spaces");
            //gets the user input in conventional x,y coordinate
            String input = scanner.nextLine();
            String coordinates[] = input.split("[.,/ ]");

            //These two lines, convert conventional x,y coordinates (starting from 0) into array index
            //Subtraction of 1 is to convert the 1-base input coordinate to 0-base index
            coori = Math.abs(((Integer.parseInt(coordinates[1])) - 1) - (size - 1));
            coorj = (Integer.parseInt(coordinates[0])) - 1;

            //if statement to see if the user hit bomb
            if (coori == b1x && coorj == b1y) {
                fieldArray[b1x][b1y] = 'O';
                Main.print("That was a hit!");
                Main.print2DArray(fieldArray, fieldArray.length);
                Main.print("\nYou won in " + ((numTry - i) + 1) + " moves.\nGood job!");

                return;
                //else statement for when the user did not git the bomb. It indicates the location of splash with X
            } else {
                fieldArray[coori][coorj] = 'X';
                Main.print("SPLASH! You hit water. X marks the spot");
            } //else

            Main.print2DArray(fieldArray, fieldArray.length);

        } //for
        Main.print("You lost :( \nTry again later.");


    } //play1

    public static void play2(int size, int numTry) {

        //variables
        Bomb bomb = new Bomb();
        char[][] fieldArray = new char[size][size];
        //get the bombArray containing the 2 bomb objects
        bombArray =  bomb.bomb2L(size);

        //create our initial matrix
        fieldArray = Main.populateArray('-', fieldArray.length);
        Main.print2DArray(fieldArray, fieldArray.length);

        for (i = numTry; i > 0; i--) {  //for numTry

            Main.print("\nYou have " + i + " tries left.");
            Main.print("Please enter the coordinates in the form \"x,y\" with no spaces");
            //gets the user input in conventional x,y coordinate
            String input = scanner.nextLine();
            String coordinates[] = input.split("[.,/ ]");

            //These two lines, convert conventional x,y coordinates (starting from 0) into array index
            //Subtraction of 1 is to convert the 1-base input coordinate to 0-base index
            coori = Math.abs(((Integer.parseInt(coordinates[1])) - 1) - (size - 1));
            coorj = (Integer.parseInt(coordinates[0])) - 1;

            //This loop runs for each bomb present in the bombArray, then removing it from the array, if it is defused
            for (int j=0; j < bombArray.size(); j++) {
                if (coori == bombArray.get(j).x && coorj == bombArray.get(j).y ) {
                    fieldArray[coori][coorj] = 'O';
                    Main.print("That was a hit!");
                    bombArray.remove(j);
                    break;
                } // if bomb-checker
                //checks to see if this is the end of the loop (meaning input didn't match any bomb)
                if (j == bombArray.size()-1) {
                    fieldArray[coori][coorj] = 'X';
                    Main.print("SPLASH! You hit water. X marks the spot");
                } //if no bomb was defused
            } //for bombArray has item

            //checks to see if there are any bombs left in the array, if there is none, it terminates the main for loop
            if (bombArray.size() == 0) {
                Main.print("You won!");
                break;
            }

            // Print the updated matrix
            Main.print2DArray(fieldArray, fieldArray.length);

        } // for(numTry)

        //End message if they have ran through the whole loop
        if (bombArray.size() == 0) {
            Main.print("Congratulations! you have discovered all the bombs in " + ((numTry - i) + 1) + " moves."
            + "\nGood job!");
        } else if (i == 0) {
            Main.print("\nYou loose :(");
        } //else-end

    } //play2


    public static void play3(int size, int numTry) {


        //variables
        Bomb bomb = new Bomb();
        char[][] fieldArray = new char[size][size];
        //get the bombArray containing the 2 bomb objects
        bombArray =  bomb.bomb3L(size);

        //create our initial matrix
        fieldArray = Main.populateArray('-', fieldArray.length);
        Main.print2DArray(fieldArray, fieldArray.length);

        for (i = numTry; i > 0; i--) {  //for numTry

            Main.print("\nYou have " + i + " tries left.");
            Main.print("Please enter the coordinates in the form \"x,y\" with no spaces");
            //gets the user input in conventional x,y coordinate
            String input = scanner.nextLine();
            String coordinates[] = input.split("[.,/ ]");

            //These two lines, convert conventional x,y coordinates (starting from 0) into array index
            //Subtraction of 1 is to convert the 1-base input coordinate to 0-base index
            coori = Math.abs(((Integer.parseInt(coordinates[1])) - 1) - (size - 1));
            coorj = (Integer.parseInt(coordinates[0])) - 1;

            //This loop runs for each bomb present in the bombArray, then removing it from the array, if it is defused
            for (int j=0; j < bombArray.size(); j++) {
                if (coori == bombArray.get(j).x && coorj == bombArray.get(j).y ) {
                    fieldArray[coori][coorj] = 'O';
                    Main.print("That was a hit!");
                    bombArray.remove(j);
                    break;
                } // if bomb-checker
                //checks to see if this is the end of the loop (meaning input didn't match any bomb)
                if (j == bombArray.size()-1) {
                    fieldArray[coori][coorj] = 'X';
                    Main.print("SPLASH! You hit water. X marks the spot");
                } //if no bomb was defused
            } //for bombArray has item

            //checks to see if there are any bombs left in the array, if there is none, it terminates the main for loop
            if (bombArray.size() == 0) {
                Main.print("You won!");
                break;
            }

            // Print the updated matrix
            Main.print2DArray(fieldArray, fieldArray.length);

        } // for(numTry)

        //End message if they have ran through the whole loop
        if (bombArray.size() == 0) {
            Main.print("Congratulations! you have discovered all the bombs in " + ((numTry - i) + 1) + " moves."
                    + "\nGood job!");
        } else if (i == 0) {
            Main.print("\nYou loose :(");
        } //else-end

    } //play3




} //Play class
