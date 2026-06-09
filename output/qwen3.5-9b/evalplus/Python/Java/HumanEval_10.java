package com.example;
public class HumanEval_10 {

    public static boolean isPalindrome(String string) {
        /** Test if given string is a palindrome */
        return string.equals(new StringBuilder(string).reverse().toString());
    }

    public static String makePalindrome(String string) {
        /** Find the shortest palindrome that begins with a supplied string.
         * Algorithm idea is simple:
         * - Find the longest postfix of supplied string that is a palindrome.
         * - Append to the end of the string reverse of a string prefix that comes before the palindromic suffix.
         * >>> makePalindrome('')
         * ''
         * >>> makePalindrome('cat')
         * 'catac'
         * >>> makePalindrome('cata')
         * 'catac'
         */
        if (isPalindrome(string)) {
            return string;
        }
        for (int i = 0; i < string.length(); i++) {
            if (isPalindrome(string.substring(i))) {
                return string + new StringBuilder(string.substring(0, i)).reverse().toString();
            }
        }
        return string;
    }
}