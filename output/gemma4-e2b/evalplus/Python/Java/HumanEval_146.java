package com.example;
class Solution {
    public int specialFilter(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            // Condition 1: number must be greater than 10
            if (num > 10) {
                String s = String.valueOf(num);
                
                // Condition 2 & 3: first and last digits must be odd
                // Since num > 10, the string will have at least 2 characters.
                
                // Get the first digit
                int firstDigit = Character.getNumericValue(s.charAt(0));
                
                // Get the last digit
                int lastDigit = Character.getNumericValue(s.charAt(s.length() - 1));
                
                // Check if both are odd
                boolean firstIsOdd = (firstDigit % 2 != 0);
                boolean lastIsOdd = (lastDigit % 2 != 0);
                
                if (firstIsOdd && lastIsOdd) {
                    ans++;
                }
            }
        }
        return ans;
    }
}