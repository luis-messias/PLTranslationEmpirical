package com.example;
public class HumanEval_85 {

    public static void main(String[] args) {

        int result = add(new int[]{4, 2, 6, 7});

        System.out.println(result); // Output should be: 2
    }


    public static int add(int[] lst) {

        int s = 0;

        for (int i = 1; i < lst.length; i += 2) {

            if (lst[i] % 2 == 0) {

                s += lst[i];

            }

        }

        return s;

    }

}