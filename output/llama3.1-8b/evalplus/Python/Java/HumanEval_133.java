package com.example;
import java.util.function.Function;
import java.lang.Math;

public class HumanEval_133 {
    public static int sumSquares(int[] lst) {
        return java.util.Arrays.stream(lst).mapToObj(x -> Math.ceil(x)).mapToInt(Function.identity()).sum();
    }

    public static void main(String[] args) {
        System.out.println(sumSquares(new int[]{1, 2, 3})); // Output: 14
        System.out.println(sumSquares(new int[]{1, 4, 9})); // Output: 98
        System.out.println(sumSquares(new int[]{1, 3, 5, 7})); // Output: 84
        System.out.println(sumSquares(new int[]{1, 4, 0})); // Output: 29
        System.out.println(sumSquares(new int[]{-2, 1, 1})); // Output: 6
    }
}