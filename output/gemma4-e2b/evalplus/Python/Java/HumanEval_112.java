package com.example;
class Solution {
    public static Object[] reverseDelete(String s, String c) {
        // Step 1: Delete characters in s that are equal to any character in c
        StringBuilder ssBuilder = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Check if the character ch is NOT present in string c
            boolean shouldKeep = true;
            for (int j = 0; j < c.length(); j++) {
                if (ch == c.charAt(j)) {
                    shouldKeep = false;
                    break;
                }
            }
            
            if (shouldKeep) {
                ssBuilder.append(ch);
            }
        }
        
        String ss = ssBuilder.toString();
        
        // Step 2: Check if the result string is a palindrome
        String reversedSs = new StringBuilder(ss).reverse().toString();
        boolean isPalindrome = ss.equals(reversedSs);
        
        // Return the result string and the palindrome check result
        return new Object[]{ss, isPalindrome};
    }
}