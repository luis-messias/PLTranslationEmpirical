package com.example;
public class HumanEval_48 {
    public static boolean isPalindrome(String text) {
        /**
         * Checks if given string is a palindrome
         */
        return text.equals(new StringBuilder(text).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("aaaaa"));
        System.out.println(isPalindrome("zbcd"));
    }
}