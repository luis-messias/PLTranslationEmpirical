package com.example;
class Solution {
    /**
     * Helper function to determine if a single number contributes 1 or 0 to the count.
     * The logic follows the Python implementation: the first digit is negative if the number is negative,
     * and subsequent digits are positive.
     */
    private static int judge(int x) {
        String s = String.valueOf(x);
        boolean isNegative = s.startsWith("-");
        
        // Extract the absolute digits string
        String digitsStr = isNegative ? s.substring(1) : s;
        
        if (digitsStr.isEmpty()) {
            // This case handles x=0, where digitsStr is "0". If x=0, sum is 0.
            // If x=0, s="0", digitsStr="0".
            if (x == 0) return 0;
            return 0; // Should not happen for standard integers
        }
        
        int sum = 0;
        char[] chars = digitsStr.toCharArray();
        
        // Handle the first digit
        int firstDigit = Character.getNumericValue(chars[0]);
        if (isNegative) {
            sum -= firstDigit;
        } else {
            sum += firstDigit;
        }
        
        // Handle remaining digits
        for (int i = 1; i < chars.length; i++) {
            int digit = Character.getNumericValue(chars[i]);
            sum += digit;
        }