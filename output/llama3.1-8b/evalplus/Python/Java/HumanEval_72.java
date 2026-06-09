package com.example;
import java.util.Arrays;

public class HumanEval_72 {
    public static boolean willItFly(int[] q, int w) {
        return Arrays.equals(q, reverseArray(q)) && sumOfArray(q) <= w;
    }

    private static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - i - 1];
        }
        return reversed;
    }

    private static int sumOfArray(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}