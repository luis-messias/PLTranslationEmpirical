package com.example;
public class HumanEval_102 {

    public static void main(String[] args) {

        System.out.println(chooseNum(12, 15)); // Output: 14

        System.out.println(chooseNum(13, 12)); // Output: -1

    }


    public static int chooseNum(int x, int y) {

        if (x > y) return -1;

        if (y % 2 == 0 && x <= y) return y; 

        else if (y % 2 != 0 && x < y) return y - 1;

        else return -1;

    }

}