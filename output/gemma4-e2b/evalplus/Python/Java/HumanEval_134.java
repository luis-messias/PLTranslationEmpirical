package com.example;
class Solution {
    public static boolean checkIfLastCharIsALetter(String txt) {
        if (txt == null || txt.isEmpty()) {
            return false;
        }

        int len = txt.length();

        if (len == 1) {
            // Equivalent to txt.isalpha()
            return Character.isLetter(txt.charAt(0));
        }

        // Equivalent to txt[-1].isalpha() and txt[-2] == " "
        char lastChar = txt.charAt(len - 1);
        char secondLastChar = txt.charAt(len - 2);

        return Character.isLetter(lastChar) && secondLastChar == ' ';
    }
}