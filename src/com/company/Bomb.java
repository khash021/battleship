package com.company;

/**
 *  This class is responsible for randomly selecting bomb(s) coordinates.
 *
 */


public class Bomb {

    //default constructor
    Bomb(){}

    //Generates a random number between 0 and i (input)
    public static int random (int i) {
        int random = (int) (Math.random() * (i+1));
        return random;
    }

    /**
     * Function to check whether an index is in bound of the array
     *
     * @param size :size of the array.
     * @param index :index to checked
     * @return true is the given index is within bounds of the given array size
     */
    private boolean inBounds(int size, int index){
        if (index >= 0 && index < size) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *  Method for creating a single bomb
     * @param size :is the size of the 2-D symmetrical array (number of rows, or columns; not the total number of
     *             elements present in the array
     * @return output[] :an integer array of the bomb coordinate with the format [i][j]
     *                   (index 0 being row, index 1 being column)
     */
    public int[] bomb1(int size) {
        int[] output = new int[2];
        int b1x = random(size - 1);
        output[0] = b1x;
        int b1y = random(size - 1);
        output[1] = b1y;
        return output;
    }

    /**
     * Method for creating a 2-grid diagonal bomb. (the two bomb locations are next to each other)
     * @param size :is the size of the 2-D symmetrical array (number of rows, or columns; not the total number of
     *             elements present in the array
     * @return output[] :an integer array of the bomb coordinate with the format [bomb1-i][bomb1-j][bomb2-i][bomb2-j]
     *
     *         After generating the first bomb location, it then tries to create a second bomb using randomly
     *         generated number (checking inBound before assigning them)
     */
    public int[] bomb2d (int size) {
        //declaring and initializing variables
        int[] output = new int[4];
        int b2x, b2y;

        //creating the 1st bomb
        int b1x = random(size - 1);
        output[0] = b1x;
        int b1y = random(size - 1);
        output[1] = b1y;

        //random numbers (either 1 or 0) used for generating the 2nd bomb
        int random1 = random(1);
        int random2 = random(1);
        //2nd bomb-x
        switch (random1) {
            //For this case it tries to subtract first, if not in bound then adds
            case 0:
                if (this.inBounds(size, b1x - 1)) {
                    b2x = b1x - 1;
                } else {
                    b2x = b1x +1;
                } //if
                output[2] = b2x;
                break;
            case 1:
                if (this.inBounds(size, b1x + 1)) {
                    b2x = b1x + 1;
                } else {
                    b2x = b1x - 1;
                }
                output[2] = b2x;
                break;
        } //switch
        //Same logic for 2nd bomb-y
        switch (random2) {
            case 0:
                if (this.inBounds(size, b1y - 1)) {
                    b2y = b1y - 1;
                } else {
                    b2y = b1y +1;
                } //if
                output[3] = b2y;
                break;
            case 1:
                if (this.inBounds(size, b1y + 1)) {
                    b2y = b1y + 1;
                } else {
                    b2y = b1y - 1;
                }
                output[3] = b2y;
                break;
        } //switch
        return output;
    } //bomb2d()

    /**
     * Method for creating a 2-grid linear bomb; horizontal, or vertical (the two bomb locations are next to each other)
     * @param size :is the size of the 2-D symmetrical array (number of rows, or columns; not the total number of
     *             elements present in the array
     * @return output[] :an integer array of the bomb coordinate with the format [bomb1-i][bomb1-j][bomb2-i][bomb2-j]
     *
     *         After generating the first bomb location, it then tries to create a second bomb using randomly
     *         generated number (checking inBound before assigning them)
     */
    public int[] bomb2 (int size) {
        //declaring and initializing variables
        int[] output = new int[4];
        int b2x, b2y;

        //creating the 1st bomb
        int b1x = random(size - 1);
        output[0] = b1x;
        int b1y = random(size - 1);
        output[1] = b1y;

        //random numbers (either 1 or 0) used for generating the 2nd bomb
        int random1 = random(1);
        int random2 = random(1);

        //random number (1 or 0) for direction logic
        int randomHV = random(1);
        //construction logic (0 creates vertical; 1 creates horizontal)
        switch (randomHV) {
            //vertical (b2x stays the same, calculate b2y)
            case 0:
                b2x = b1x;
                output[2] = b2x;
                switch (random1) {
                    case 0:
                        if (this.inBounds(size, b1y - 1 )) {
                            b2y = b1y - 1;
                        } else {
                            b2y = b1y + 1;
                        } //if
                        output[3] = b2y;
                        break;
                    case 1:
                        if (this.inBounds(size, b1y + 1)) {
                            b2y = b1y +1;
                        } else {
                            b2y = b1y -1;
                        } //if
                        output[3] = b2y;
                        break;
                } //switch random1
                return output;

            //horizontal (b2y stays the same, calculate b2x)
            case 1:
                b2y = b1y;
                output[3] = b2y;
                switch (random2) {
                    case 0:
                        if (this.inBounds(size, b1x - 1)) {
                            b2x = b1x - 1;
                        } else {
                            b2x = b1x + 1;
                        } //if
                        output[2] = b2x;
                        break;
                    case 1:
                        if (this.inBounds(size, b1x + 1)) {
                            b2x = b1x + 1;
                        } else {
                            b2x = b1x - 1;
                        } //if
                        output[2] = b2x;
                        break;
                } //switch random2
                return output;
        } //switch
        return output;
    } //bomb2


} //main
