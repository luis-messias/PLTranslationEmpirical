package com.example;
class Solution {
    public String removeVowels(String text) {
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";

        for (char ch : text.toCharArray()) {
            // Check if the character is NOT a vowel
            if (vowels.indexOf(ch) == -1) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}