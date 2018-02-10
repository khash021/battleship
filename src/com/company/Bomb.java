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

    public int[] bomb1(int size) {
        int[] output = new int[2];
        int b1x = random(size - 1);
        output[0] = b1x;
        int b1y = random(size - 1);
        output[1] = b1y;
        return output;
    }

    /**
     * 2-grid diagonal bomb method
     *
     */
    public int[] bomb2d (int size) {
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
        //2nd bomb-y
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

    public int[] bomb2 (int size) {
        int[] output = new int[4];
        int b2x, b2y;
        int b1x = random(size - 1);
        output[0] = b1x;
        int b1y = random(size - 1);
        output[1] = b1y;
        //rendom variables for x-y construction logic
        int random1 = random(1);
        int random2 = random(1);
        //random variable for direction logic
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
