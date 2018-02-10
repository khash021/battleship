package com.company;

import java.util.Scanner;

public class Main {

    //Print function for strings
    private static void print(String s) {
        System.out.println(s);
    }
    public static void printIntArray (int[] array) {
        for (int i=0; i<array.length;i++ ) {
            System.out.println(array[i]);
        }
    }
    //Print function for 2D-arrays.
    private static void print2DArray (char[][] array, int size) {
        System.out.println("");
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //Function for populating a symmetrical 2D array (size as an argmt) using the input char, and number of
    private static char[][] populateArray (char c, int number){
        char[][] array = new char[number][number];
        for (int i=0;i<number; i++ ) {
            for (int j=0; j<number; j++) {
                array[i][j] = c;
            }
        }
        return array;
    }



    public static void main(String[] args) {


        //Variables
        //size of the generated matrix and declare out 2d matrix of the battlefield
        final int size =3;
//        char [][] fieldArray = new char[size][size];
        int bomb1X, bomb1Y, bomb2X, bomb2Y;
//        bombX = Bomb.random(size-1);
//        bombY = Bomb.random(size-1);



        //populate the field array with - for the start of the game
//        fieldArray = populateArray('-', fieldArray.length);


        //Game instruction
//        print("\nThe game is a Battleship simulator with " + size + " rows and columns.\nTry to guess the bomb location" +
//                " in as little tries as possible to win.\nEnter the location by giving the x-coordinate, followed by" +
//                " the y-coordante, separated by \" , \"");
//        print("Please choose the difficulty of the game." +
//                "\n1 ---------> hard (3 tries)\n2 ---------> moderate (5 tries)" +
//                "\n3 ---------> easy (7 tries)");

        //Difficulty
//        final int numTry= Difficulty.getDifficulty();

        //print the initial array
//        print2DArray(fieldArray, fieldArray.length);


        for (int counter=0; counter<100; counter++) {
            char [][] fieldArray = new char[size][size];
            fieldArray = populateArray('-', fieldArray.length);
            Bomb bomb =new Bomb();
            int[] bombArray = new int[4];
            bombArray = bomb.bomb2(size);
            bomb1X = bombArray[0];
            bomb1Y = bombArray[1];
            bomb2X = bombArray[2];
            bomb2Y = bombArray[3];

            fieldArray[bomb1X][bomb1Y] = 'X';
            fieldArray[bomb2X][bomb2Y] = 'X';

            print2DArray(fieldArray, fieldArray.length);
        }








        //games play
//        for (int i=numTry; i>0; i--) {
//            print("\nYou have " + i + " tries left.");
//            print("Please enter the coordinates in the form \"x,y\" with no spaces");
//            //gets the user input in conventional x,y coordinate
//            Scanner scanner = new Scanner(System.in);
//            String input = scanner.nextLine();
//            String coordinates[] = input.split("[.,/ ]");
//            /* These two lines, convert conventional x,y coordinates (starting from 0) into array index
//                Subtraction of 1 is to convert the 1-base input coordinate to 0-base index
//             */
//            int coori = Math.abs(((Integer.parseInt(coordinates[1])) - 1) -(size-1)) ;
//            int coorj = (Integer.parseInt(coordinates[0])) - 1;
//            //if statement to see if the user hit bomb
//            if (coori == bombX && coorj == bombY) {
//                fieldArray[bombX][bombY] = 'O';
//                print("That was a hit!");
//                print2DArray(fieldArray,fieldArray.length);
//                print("\nYou win.");
//                return;
//            //else statement for when the user did not git the bomb. It indicates the location of splash with X
//            } else {
//                fieldArray [coori][coorj] = 'X';
//                print("SPLASH! You hit water. X marks the spot");
//            }
//            print2DArray(fieldArray,fieldArray.length);
//
//        }
//        print("You lost :( \nTry again later.");
    }
}
