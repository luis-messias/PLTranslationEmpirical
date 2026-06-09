package com.example;
public class HumanEval_151 {
    public static int doubleTheDifference(int[] lst) {
        int ans = 0;
        for (int num : lst) {
            if (num % 2 == 1 && num > 0) {
                ans += num * num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(doubleTheDifference(new int[]{1, 3, 2, 0})); // 10
        System.out.println(doubleTheDifference(new int[]{-1, -2, 0})); // 0
        System.out.println(doubleTheDifference(new int[]{9, -2})); // 81
        System.out.println(doubleTheDifference(new int[]{0})); // 0  
    }
}