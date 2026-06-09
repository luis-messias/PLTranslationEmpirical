package com.example;
class Solution {
    /**
     * Given a positive integer n, return an array containing the number of even and odd
     * integer palindromes that fall within the range(1, n), inclusive.
     * The returned array is [even_count, odd_count].
     */
    public int[] evenOddPalindrome(int n) {
        int oddCnt = 0;
        int evenCnt = 0;

        for (int i = 1; i <= n; i++) {
            if (isPalindrome(i)) {
                if (i % 2 != 0) {
                    oddCnt++;
                } else {
                    evenCnt++;
                }
            }
        }
        // Return {even_count, odd_count}
        return new int[]{evenCnt, oddCnt};
    }

    /**
     * Checks if a number is a palindrome.
     */
    private boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        String reversedS = new StringBuilder(s).reverse().toString();
        return s.equals(reversedS);
    }
}