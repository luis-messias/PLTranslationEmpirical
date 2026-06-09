package com.example;
public class HumanEval_48 {

    public static boolean isPalindrome(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }
        
        String reversedText = new StringBuilder(text).reverse().toString();
        return text.equals(reversedText);
    }

}