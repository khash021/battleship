package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *      This class is responsible for handling all test matrixes.
 *      It is used to generate different type of bombs, given the matrix size, and create it numerous times
 *      for checking the bomb methods.
 */



public class Test {

    //default constructor
    Test(){}

    /**
     *      This method is the one that does all the work!
     *      Its only output is the printed matrix(es) with the desired number of bomb
     *      It asks the user: the size of the matrix, the number of bombs to be created, and the number of simulations.
     *
     */
    public static void test() {

        //variables
        int size, bombSize, simSize;
        int b1x, b1y, b2x, b2y, b3x, b3y;
        ArrayList<Bomb> bombArray = new ArrayList<>();
        Bomb bomb = new Bomb();
        Scanner scanner = new Scanner(System.in);


        Main.print("Please enter the size of the matrix (i.e. number of rows)");
        size = scanner.nextInt();
        while (size<2 || size>10) {
            Main.print("Invalid entry. Enter a number between 2 and 10");
            size = scanner.nextInt();
        }
        Main.print("Please enter the number of bombs to be created (1, 2, or 3)");
        bombSize = scanner.nextInt();

        //Checks to makee sure your bombSize size is smaller than the size of the matrix
        while (bombSize >= size || bombSize > 3) {
            Main.print("Invalid entry. Please enter a number between 1 and 3)" +
                    "\nPlease enter the number of bombs to be created");
            bombSize = scanner.nextInt();
        } //while
        Main.print("Please enter the number of simulated matrix(es):");
        simSize = scanner.nextInt();
        while (simSize <=0 || simSize>100) {
            Main.print("Invalid entry. Please enter a number between 1 and 100");
            simSize = scanner.nextInt();
        }

        //Declare the output array
        char[][] outputArray = new char[size][size];


        //switch case for for calling different methods depending on the bombSize type
        switch (bombSize) {
            case 1:
                //Create the loop based on the input (number of randomly generated matrix(es) )
                for (int i =0; i<simSize; i++) {
                    //create a new bomb object
                    bomb = new Bomb();
                    //get the bomb as an object in the arrayList
                    bombArray = bomb.bomb1(size);
                    //get the x,y of the bomb
                    b1x = bombArray.get(0).x;
                    b1y = bombArray.get(0).y;
                    outputArray = Main.populateArray('-', outputArray.length);
                    outputArray[b1x][b1y] = 'X';
                    Main.print2DArray(outputArray, outputArray.length);
                } //for
                break;
            case 2:
                for (int i=0; i<simSize; i++) {
                    bomb = new Bomb();
                    bombArray = bomb.bomb2L(size);
                    b1x = bombArray.get(0).x;
                    b1y = bombArray.get(0).y;
                    b2x = bombArray.get(1).x;
                    b2y = bombArray.get(1).y;
                    outputArray = Main.populateArray('-', outputArray.length);
                    outputArray[b1x][b1y] = 'X';
                    outputArray[b2x][b2y] = 'X';
                    Main.print2DArray(outputArray, outputArray.length);
                } //for
                break;
            case 3:
                for (int i=0; i<simSize; i++) {
                    bomb = new Bomb();
                    bombArray = bomb.bomb3L(size);
                    b1x = bombArray.get(0).x;
                    b1y = bombArray.get(0).y;
                    b2x = bombArray.get(1).x;
                    b2y = bombArray.get(1).y;
                    b3x = bombArray.get(2).x;
                    b3y = bombArray.get(2).y;
                    outputArray = Main.populateArray('-', outputArray.length);
                    outputArray[b1x][b1y] = 'X';
                    outputArray[b2x][b2y] = 'X';
                    outputArray[b3x][b3y] = 'X';
                    Main.print2DArray(outputArray, outputArray.length);
                } //for
        } //switch

    } //Test

} //Test class
