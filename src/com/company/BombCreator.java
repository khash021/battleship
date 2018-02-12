package com.company;

import java.util.ArrayList;

public class BombCreator {

    //default constructor
    BombCreator(){}

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


    //Method for making a single bomb
    public static ArrayList<Bomb> create1(int size) {

        Bomb bomb = new Bomb();
        ArrayList<Bomb> outputArray = new ArrayList<>();
        int x = Bomb.random(size - 1);
        bomb.x = x;
        int y = Bomb.random(size - 1);
        bomb.y = y;
        outputArray.add(bomb);
        return outputArray;
    } //create1
}
