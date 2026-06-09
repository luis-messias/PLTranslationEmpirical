package com.example;
class Solution {
    /**
     * Given a positive integer n, return the product of the odd digits.
     * Return 0 if all digits are even.
     * For example:
     * digits(1)  == 1
     * digits(4)  == 0
     * digits(235) == 15
     */
    public int digits(int n) {
        boolean hasOdd = false;
        int prod = 1;

        String s = String.valueOf(n);
        for (char ch : s.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            if (digit % 2 != 0) {
                hasOdd = true;
                prod *= digit;
            }
        }

        return hasOdd ? prod : 0;
    }
}