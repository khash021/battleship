package com.company;

import java.util.Scanner;

/**
 *      This class is responsible for handling all test matrixes.
 *      It is used to generate different type of bombs, given the matrix size, and create it numerous times
 *      for checking the bomb methods.
 */



public class Test {

    //default constructor
    Test(){}

    public static void test() {
        int size, bombSize, simSize;
        int b1x, b1y, b2x, b2y, b3x, b3y;
        int[] bombArray;
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

        //Declare the output array and bomb object
        char[][] outputArray = new char[size][size];
        Bomb bomb = new Bomb();

        //switch case for for calling different methods depending on the bombSize type
        switch (bombSize) {
            case 1:
                //variables
                bombArray = new int[bombSize*2];
                //Create the loop based on the input (number of randomly generated matrix(es) )
                for (int i =0; i<simSize; i++) {
                    //Create the bomb by calling bomb1 method and storing it in the bombArray. Then getting the coordinates
                    bombArray = bomb.bomb1(size);
                    b1x = bombArray[0];
                    b1y = bombArray[1];
                    outputArray = Main.populateArray('-', outputArray.length);
                    outputArray[b1x][b1y] = 'X';
                    Main.print2DArray(outputArray, outputArray.length);
                } //for
                break;
            case 2:
                bombArray = new int[bombSize*2];
                for (int i=0; i<simSize; i++) {
                    bombArray = bomb.bomb2L(size);
                    b1x = bombArray[0];
                    b1y = bombArray[1];
                    b2x = bombArray[2];
                    b2y = bombArray[3];
                    outputArray = Main.populateArray('-', outputArray.length);
                    outputArray[b1x][b1y] = 'X';
                    outputArray[b2x][b2y] = 'X';
                    Main.print2DArray(outputArray, outputArray.length);
                } //for
                break;
            case 3:
                bombArray = new int[bombSize*2];
                for (int i=0; i<simSize; i++) {
                    bombArray = bomb.bomb3L(size);
                    b1x = bombArray[0];
                    b1y = bombArray[1];
                    b2x = bombArray[2];
                    b2y = bombArray[3];
                    b3x = bombArray[4];
                    b3y = bombArray[5];
                    outputArray = Main.populateArray('-', outputArray.length);
                    outputArray[b1x][b1y] = 'X';
                    outputArray[b2x][b2y] = 'X';
                    outputArray[b3x][b3y] = 'X';
                    Main.print2DArray(outputArray, outputArray.length);
                } //for
        } //switch

    } //Test

} //Test class
