package com.example;
public class HumanEval_40 {

    public static boolean triples_sum_to_zero(int[] arr) {

        for (int i = 0; i < arr.length - 2; i++) {

            for (int j = i + 1; j < arr.length - 1; j++) {

                for (int k = j + 1; k < arr.length; k++) {

                    if ((arr[i] + arr[j] + arr[k]) == 0) {

                        return true;

                    }

                }

            }

        }

        return false;

    }


    public static void main(String[] args) {

        System.out.println(triples_sum_to_zero(new int[]{1, 3, -2, 1})); // True

        System.out.println(triples_sum_to_zero(new int[]{1, 5, 0}));     // False

        System.out.println(triples_sum_to_zero(new int[]{-4, 9, 7, 6, 8, -3}));

    }

}