package com.example;
import java.util.Arrays;

public class HumanEval_9 {
    public static int[] rollingMax(int[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int max = Arrays.stream(numbers).limit(i + 1).max().getAsInt();
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 3, 4, 2};
        System.out.println(Arrays.toString(rollingMax(numbers)));
    }
}