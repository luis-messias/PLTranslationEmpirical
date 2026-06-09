package com.example;
class Solution {
    /**
     * Checks if a character represents an odd digit (1, 3, 5, 7, 9).
     * Handles non-digit characters (like '-' sign).
     */
    private static boolean isOddDigit(char c) {
        if (c < '0' || c > '9') {
            return false;
        }
        int digit = c - '0';
        return digit % 2 != 0;
    }

    /**
     * Takes an array of numbers and returns the count of elements that are 
     * greater than 10 and whose first and last digits are odd.
     * 
     * @param nums The array of integers.
     * @return The count of special numbers.
     */
    public static int specialFilter(int[] nums) {
        int count = 0;

        for (int num : nums) {
            // Condition 1: Must be greater than 10
            if (num <= 10) {
                continue;
            }

            String s = String.valueOf(num);
            
            // Check first digit
            char firstChar = s.charAt(0);
            boolean isFirstOdd = isOddDigit(firstChar);

            // Check last digit
            char lastChar = s.charAt(s.length() - 1);
            boolean isLastOdd = isOddDigit(lastChar);

            // Condition 2: Both first and last digits must be odd
            if (isFirstOdd && isLastOdd) {
                count++;
            }
        }
        return count;
    }
}