package com.example;
public class HumanEval_151 {

    public static void main(String[] args) {

        System.out.println(doubleTheDifference(new int[]{1, 3, 2, 0})); // Output: 10

        System.out.println(doubleTheDifference(new int[]{-1, -2, 0}));   // Output: 0

        System.out.println(doubleTheDifference(new int[]{9, -2}));       // Output: 81

        System.out.println(doubleTheDifference(new int[]{}));             // Output: 0
    }


    public static int doubleTheDifference(int[] lst) {

        int ans = 0;

        for (int num : lst) {
            if ((num % 2 == 1 && num > 0) || !(num / Integer.toString(num).indexOf(".") != -1)) { // Check number is positive and not negative decimal
                ans += Math.pow(num, 2);
            }

        }
        return ans;

    }

}