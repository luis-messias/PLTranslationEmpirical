package com.example;
class Solution {
    public static int doubleTheDifference(int[] lst) {
        int ans = 0;
        for (int num : lst) {
            // Check if the number is odd (num % 2 != 0) and positive (num > 0).
            // The check for non-integers is implicitly handled since the input is an array of integers.
            if (num % 2 != 0 && num > 0) {
                ans += num * num;
            }
        }
        return ans;
    }
}