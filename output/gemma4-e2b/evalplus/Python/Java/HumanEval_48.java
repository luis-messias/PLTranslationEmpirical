package com.example;
class Solution {
    public boolean isPalindrome(String text) {
        if (text == null) {
            // Depending on requirements, null might throw an exception or return false.
            // Assuming standard string handling, let's treat null as not a palindrome or handle it based on context.
            // For this translation, we assume valid string input based on Python type hint.
            return false; 
        }
        
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }
}