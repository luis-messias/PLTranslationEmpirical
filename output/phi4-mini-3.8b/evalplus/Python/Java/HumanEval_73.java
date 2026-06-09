package com.example;
public class HumanEval_73 {

    public static int smallest_change(int[] arr) {

        StringBuilder reversed = new StringBuilder(new String(arr));

        for (int i = 0; i < arr.length / 2; i++) {

            if (arr[i] != Integer.parseInt(reversed.substring(i, i + 1))) {

                return 1;

            }

        }

        return 0;

    }


    public static void main(String[] args) {

        int[] example = {1, 2, 3, 5, 4, 7, 9, 6};

        System.out.println(smallest_change(example));

    }

}