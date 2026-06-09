package com.example;
class Solution {
    public String encrypt(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                // The shift is 4 based on the examples provided in the docstring, 
                // corresponding to the Python implementation's + 4.
                int originalIndex = ch - 'a';
                int newIndex = (originalIndex + 4) % 26;
                char newChar = (char) (newIndex + 'a');
                result.append(newChar);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}