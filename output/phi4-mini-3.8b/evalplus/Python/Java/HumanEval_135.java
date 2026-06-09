package com.example;
public class HumanEval_135 {

    public static int canArrange(int[] arr) {

        for (int i = arr.length - 2; i > 0; --i) {

            if (!arr[i] >= arr[i - 1]) {

                return i + 1;

            }

        }

        return -1;

    }


    public static void main(String[] args) {

        int[] exampleArray1 = {1, 2, 4, 3, 5};

        System.out.println(canArrange(exampleArray1)); // Output: 3

        int[] exampleArray2 = {1, 2, 3};

        System.out.println(canArrange(exampleArray2)); // Output: -1

    }

}