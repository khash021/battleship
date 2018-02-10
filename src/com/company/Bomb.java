package com.company;


public class Bomb {

    //default constructor
    Bomb(){}

    //Generates a random number between 0 and the upper limit as an input
    public static int random (int i) {
        int random = (int) (Math.random() * (i+1));
        return random;
    }

    private boolean inBounds(int size, int index){
        if (index >= 0 && index < size) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Bomb constructor
     *
     */
    public int[] Bomb (int size) {
        int[] output = new int[4];
        int b2x, b2y;
        int b1x = random(size - 1);
        output[0] = b1x;
        int b1y = random(size - 1);
        output[1] = b1y;
        int random1 = random(1);
        int random2 = random(1);
        //2nd bomb-x
        switch (random1) {
            case 0:
                if (this.inBounds(size, b1x - 1)) {
                    b2x = b1x - 1;
                } else {
                    b2x = b1x +1;
                } //if
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
        //2nd bomb-y
        switch (random2) {
            case 0:
                if (this.inBounds(size, b1y - 1)) {
                    b2y = b1y - 1;
                } else {
                    b2y = b1y +1;
                } //if
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
    } //Bomb()



} //main
