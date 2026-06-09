package com.example;
class Solution {
    /**
     * Checks if given string is a palindrome
     * @param text The string to check.
     * @return true if the string is a palindrome, false otherwise.
     */
    public boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}