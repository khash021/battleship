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
    public static void print2DArray (char[][] array, int size) {
        System.out.println("");
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //Function for populating a symmetrical 2D array (size as an args) using the input char, and number of
    public static char[][] populateArray (char c, int size){
        char[][] array = new char[size][size];
        for (int i=0;i<size; i++ ) {
            for (int j=0; j<size; j++) {
                array[i][j] = c;
            }
        }
        return array;
    }



    public static void main(String[] args) {

        String option;
        char replay;
        Scanner scanner = new Scanner(System.in);

        print("\nWelcome to Battleship. Tell me what would you like to do? Your options are:" +
        "\n   ---> Play\n   ---> God mode");
        option = scanner.nextLine().toLowerCase();

        //The main heart of the game. this decides base on user input what to do and what to call
        switch (option) {
            case "play":
            case "p":
                replay = 'y';
                while (replay == 'y') {
                print("Coming soon! Check back soon");
                print("\nWould you like to play again? Y/N");
                replay = (scanner.nextLine()).toLowerCase().charAt(0);
                } //while
                break;
            case "god":
                replay = 'y';
                while (replay == 'y') {
                    Test.test();
                    print("\nWould you like to run the simulation again? Y/S");
                    replay = (scanner.nextLine()).toLowerCase().charAt(0);
                } //while
                break;

        } //switch

        print("Thank you, come again :)");
    } //main method
} // main class




