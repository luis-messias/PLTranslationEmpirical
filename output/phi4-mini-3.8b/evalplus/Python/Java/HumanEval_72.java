package com.example;
public class HumanEval_72 {

    public static boolean willItFly(int[] q, int w) {

        // Check if array is a palindrome (balanced)

        for (int i = 0; i < q.length / 2; i++) {
            if (q[i] != q[q.length - 1 - i]) {
                return false;
            }
        }

        // Calculate the sum of elements

        int totalWeight = 0;

        for (int weight : q) {

            totalWeight += weight;

        }


        // Check against maximum possible weight w

        if (totalWeight <= w) {

            return true;

        } else {

            return false;

        }

    }

}