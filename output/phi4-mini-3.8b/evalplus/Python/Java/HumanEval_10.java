package com.example;
public class HumanEval_10 {

    public static boolean isPalindrome(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }

    public static String makePalindrome(String str) {
        if (isPalindrome(str)) {
            return str;
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (isPalindrome(str.substring(i))) {
                return str + new StringBuilder(str.substring(0, i)).reverse().toString();
            }
        }

        throw new IllegalArgumentException("No palindrome found");
    }

}