package com.example;
class Solution {
    public static int[] evenOddPalindrome(int n) {
        int oddCnt = 0;
        int evenCnt = 0;

        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            
            // Check if i is a palindrome
            String reversed = new StringBuilder(s).reverse().toString();
            
            if (s.equals(reversed)) {
                // It is a palindrome
                if (i % 2 == 1) {
                    oddCnt++;
                } else {
                    evenCnt++;
                }
            }
        }
        // The Python code returns (even_cnt, odd_cnt)
        return new int[]{evenCnt, oddCnt};
    }
}