package com.example;
class Solution {
    /**
     * Given an integer. return a tuple that has the number of even and odd digits respectively.
     *
     * Example:
     * even_odd_count(-12) ==> (1, 1)
     * even_odd_count(123) ==> (1, 2)
     */
    public int[] evenOddCount(int num) {
        int even = 0;
        int odd = 0;
        String s = String.valueOf(Math.abs(num));

        for (char ch : s.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            if (digit % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return new int[]{even, odd};
    }
}