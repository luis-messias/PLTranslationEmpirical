package com.example;
public class HumanEval_159 {
    public static int[] eat(int number, int need, int remaining) {
        if (need <= remaining) {
            return new int[]{number + need, remaining - need};
        } else {
            return new int[]{number + remaining, 0};
        }
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(eat(5, 6, 10)));
        System.out.println(java.util.Arrays.toString(eat(4, 8, 9)));
        System.out.println(java.util.Arrays.toString(eat(1, 10, 10)));
        System.out.println(java.util.Arrays.toString(eat(2, 11, 5)));
    }
}