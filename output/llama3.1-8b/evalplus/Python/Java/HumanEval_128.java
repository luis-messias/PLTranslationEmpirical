package com.example;
public class HumanEval_128 {
    public static Integer prodSigns(int[] arr) {
        if (arr.length == 0) return null;
        for (int x : arr) {
            if (x == 0) return 0;
        }
        int sum = 0, sign = 1;
        for (int x : arr) {
            sum += Math.abs(x);
            sign *= (x / Math.abs(x));
        }
        return sum * sign;
    }

    public static void main(String[] args) {
        System.out.println(prodSigns(new int[]{1, 2, 2, -4}) == -9);
        System.out.println(prodSigns(new int[]{0, 1}) == 0);
        System.out.println(prodSigns(new int[]{}));
    }
}