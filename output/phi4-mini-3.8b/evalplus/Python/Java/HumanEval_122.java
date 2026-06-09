package com.example;
import java.util.function.Predicate;

public class HumanEval_122 {

    public static void main(String[] args) {
        int[] arr = {111, 21, 3, 4000, 5, 6, 7, 8, 9};
        int k = 4;
        System.out.println(addElements(arr, k)); // Output: 24
    }

    public static int addElements(int[] arr, int k) {
        Predicate<Integer> hasTwoOrLessDigits = x -> Integer.toString(x).length() - (x < 0 ? 1 : 0) <= 2;

        return java.util.Arrays.stream(arr, 0, Math.min(k, arr.length))
                .filter(hasTwoOrLessDigits)
                .sum();
    }
}