package com.example;
public class HumanEval_52 {

    public static boolean areAllBelowThreshold(int[] numbers, int threshold) {

        for (int number : numbers) {

            if (number >= threshold) {

                return false;

            }

        }

        return true;

    }


    public static void main(String[] args) {

        System.out.println(areAllBelowThreshold(new int[]{1, 2, 4, 10}, 100)); // True

        System.out.println(areAllBelowThreshold(new int[]{1, 20, 4, 10}, 5));   // False

    }

}