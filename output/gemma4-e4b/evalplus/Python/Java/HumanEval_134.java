package com.example;
class Solution {
    public static boolean checkIfLastCharIsALetter(String txt) {
        if (txt == null || txt.isEmpty()) {
            return false;
        }

        int length = txt.length();

        if (length == 1) {
            return Character.isLetter(txt.charAt(0));
        }

        // For length >= 2:
        // Check if the last character is a letter AND the second-to-last character is a space.
        char lastChar = txt.charAt(length - 1);
        char secondToLastChar = txt.charAt(length - 2);

        return Character.isLetter(lastChar) && secondToLastChar == ' ';
    }
}