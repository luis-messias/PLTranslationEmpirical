package com.example;
class Solution {
    public int digits(int n) {
        boolean hasOdd = false;
        int prod = 1;
        int temp = n;

        // Handle the case where n is 0 explicitly if necessary, though the loop handles positive integers.
        if (temp == 0) {
            return 0;
        }

        while (temp > 0) {
            int digit = temp % 10;
            if (digit % 2 != 0) {
                hasOdd = true;
                prod *= digit;
            }
            temp /= 10;
        }

        if (!hasOdd) {
            return 0;
        } else {
            return prod;
        }
    }
}