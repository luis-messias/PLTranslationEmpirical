package com.example;
public class HumanEval_43 {

    public static boolean pairsSumToZero(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (i != j && arr[i] + arr[j] == 0) {

                    return true;

                }

            }

        }

        return false;

    }


    public static void main(String[] args) {

        int[] test1 = {1, 3, 5, 0};

        System.out.println(pairsSumToZero(test1)); // False


        int[] test2 = {1, 3, -2, 1};

        System.out.println(pairsSumToZero(test2)); // False

    }

}