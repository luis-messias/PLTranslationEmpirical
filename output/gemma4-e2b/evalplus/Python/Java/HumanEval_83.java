package com.example;
class Solution {
    public static int starts_one_ends(int n) {
        if (n == 1) {
            return 1;
        }
        // The formula is 18 * 10^(n - 2)
        // Use Math.pow for exponentiation and cast the result to long for safety before returning int.
        long powerOfTen = (long) Math.pow(10, n - 2);
        return 18 * powerOfTen;
    }
}