package com.example;
public static boolean isPalindrome(String text) {
    /**
     * Checks if given string is a palindrome
     * @param text the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    return text.equals(new StringBuilder(text).reverse().toString());
}