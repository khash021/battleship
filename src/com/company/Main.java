package com.company;

import java.util.Scanner;

public class Main {

    //Print function for strings
    public static void print(String s) {
        System.out.println(s);
    }

    //Print integer
    public static void printInt (int i) {
        System.out.println(i);
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
        int bomb1X, bomb1Y, bomb2X, bomb2Y;
        Bomb bomb = new Bomb();

        //Get the size of the matrix from the user; then declare and initialize the field array
        final int size = Difficulty.getSize();
        char [][] fieldArray = new char[size][size];

        //populate the field array with - for the start of the game
        fieldArray = populateArray('-', fieldArray.length);

        //Game instruction
        print("\nThe game is a Battleship simulator with " + size + " rows and columns.\nTry to guess the bomb location" +
                " in as little tries as possible to win.\nEnter the location by giving the x-coordinate, followed by" +
                " the y-coordante, separated by \" , \"");
        print("Please choose the difficulty of the game." +
                "\n1 ---------> hard (3 tries)\n2 ---------> moderate (5 tries)" +
                "\n3 ---------> easy (7 tries)");

        //Difficulty
        final int numTry= Difficulty.getDifficulty();

        //print the initial array
        print2DArray(fieldArray, fieldArray.length);

        //One bomb location
//        int[] bombArray = new int[2];
//        bombArray = bomb.bomb1(size);
//        bomb1X = bombArray[0];
//        bomb1Y = bombArray[1];

        //two bomb locations
        int[] bombArray = new int[4];
        bombArray = bomb.bomb2L(size);
        bomb1X = bombArray[0];
        bomb1Y = bombArray[1];
        bomb2X = bombArray[2];
        bomb2Y = bombArray[3];

//        print("b1-x: " + bomb1X);
//        print("b1-y: " + bomb1Y);
//        print("b2-x: " + bomb2X);
//        print("b1-y: " + bomb2Y);

        //games play
        int i;
        for (i=numTry; i>0; i--) {
            print("\nYou have " + i + " tries left.");
            print("Please enter the coordinates in the form \"x,y\"");
            //gets the user input in conventional x,y coordinate
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String coordinates[] = input.split("[.,/ ]");
            /* These two lines, convert conventional x,y coordinates (starting from 0) into array index
                Subtraction of 1 is to convert the 1-base input coordinate to 0-base index
             */
            int coori = Math.abs(((Integer.parseInt(coordinates[1])) - 1) -(size-1)) ;
            int coorj = (Integer.parseInt(coordinates[0])) - 1;

            //if statement to check whether bomb-1 has been found (i.e. bombX1 = -1)
            if (bomb1X != -1) {    //if bomb-1 checker
                //checks to see if the user has hit bomb1
                if (coori == bomb1X && coorj == bomb1Y) {   //if bomb-1
                    fieldArray[bomb1X][bomb1Y] = 'O';
                    bomb1X = -1; //this means bomb 1 has already been defused
//                    print2DArray(fieldArray,fieldArray.length);
                    print("That was a hit!");
                    // this skips the rest, and goes back to the for since we can only hit one bomb at a time
//                    if (bomb1X == -1)
//                        continue;
                    //else statement for when the user did not git the bomb. It indicates the location of splash with X
                } else {  //else bomb-1
                    fieldArray [coori][coorj] = 'X';
                    print("SPLASH! You hit water. X marks the spot");
                } // else bomb-1
            } else if (bomb2X != -1) {  //if bomb2-checker
                if (coori == bomb2X && coorj == bomb2Y) {  //if bomb-2
                    fieldArray[bomb2X][bomb2Y] = 'O';
                    bomb2X = -1;
//                    print2DArray(fieldArray,fieldArray.length);
                    print("That was a hit!");
                } else {  //else bomb-2
                    fieldArray [coori][coorj] = 'X';
                    print("SPLASH! You hit water. X marks the spot");
                }
            }  //if bomb-2 checker
            print2DArray(fieldArray,fieldArray.length);
            if (bomb1X == -1 && bomb2X == -1) {  //if both -1
                print("You won!");
                break;
            } //if both -1
//            print("You lost :( \nTry again later.");
        } //for

        //message if they have won
        if (bomb1X == -1 && bomb2X == -1) {
            print("Congratulations! you have discovered all the bombs");
        } else if (i == 0) {
            print("\nYou loose :(");
        }




//        print2DArray(fieldArray,fieldArray.length);


//        print("\nYou won in " + ((numTry - i)+1) + " moves.\nGood job!");


    } //main method
} // main class

/*
  ----------------------------<<<<<  END  >>>>-------------------------------------------
 */

// creating 100 grids
//        for (int counter=0; counter<100; counter++) {
//            char [][] fieldArray = new char[size][size];
//            fieldArray = populateArray('-', fieldArray.length);
//            Bomb bomb =new Bomb();
//            int[] bombArray = new int[4];
//            bombArray = bomb.bomb2(size);
//            bomb1X = bombArray[0];
//            bomb1Y = bombArray[1];
//            bomb2X = bombArray[2];
//            bomb2Y = bombArray[3];
//
//            fieldArray[bomb1X][bomb1Y] = 'X';
//            fieldArray[bomb2X][bomb2Y] = 'X';
//
//            print2DArray(fieldArray, fieldArray.length);
//        }


//1 bomb games play
//        for (int i=numTry; i>0; i--) {
//                print("\nYou have " + i + " tries left.");
//                print("Please enter the coordinates in the form \"x,y\" with no spaces");
//                //gets the user input in conventional x,y coordinate
//                Scanner scanner = new Scanner(System.in);
//                String input = scanner.nextLine();
//                String coordinates[] = input.split("[.,/ ]");
//            /* These two lines, convert conventional x,y coordinates (starting from 0) into array index
//                Subtraction of 1 is to convert the 1-base input coordinate to 0-base index
//             */
//                int coori = Math.abs(((Integer.parseInt(coordinates[1])) - 1) -(size-1)) ;
//                int coorj = (Integer.parseInt(coordinates[0])) - 1;
//                //if statement to see if the user hit bomb
//                if (coori == bomb1X && coorj == bomb1Y) {
//                fieldArray[bomb1X][bomb1Y] = 'O';
//                print("That was a hit!");
//                print2DArray(fieldArray,fieldArray.length);
//                print("\nYou won in " + ((numTry - i)+1) + " moves.\nGood job!");
//                return;
//                //else statement for when the user did not git the bomb. It indicates the location of splash with X
//                } else {
//                fieldArray [coori][coorj] = 'X';
//                print("SPLASH! You hit water. X marks the spot");
//                }
//                print2DArray(fieldArray,fieldArray.length);
//
//                }
//                print("You lost :( \nTry again later.");