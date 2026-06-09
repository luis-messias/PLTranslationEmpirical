package com.example;
import java.util.stream.IntStream;

public class HumanEval_122 {
    public static int addElements(int[] arr, int k) {
        return IntStream.range(0, Math.min(k, arr.length))
                .map(i -> arr[i])
                .filter(x -> String.valueOf(Math.abs(x)).length() <= 2)
                .sum();
    }

    public static void main(String[] args) {
        int[] arr = {111, 21, 3, 4000, 5, 6, 7, 8, 9};
        System.out.println(addElements(arr, 4));
    }
}