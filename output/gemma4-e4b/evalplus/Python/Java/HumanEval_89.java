package com.example;
class Solution {
    public String encrypt(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                // Calculate the 0-indexed position (0 for 'a', 25 for 'z')
                int originalPos = c - 'a';
                
                // Apply the shift of 4 and wrap around using modulo 26
                int newPos = (originalPos + 4) % 26;
                
                // Convert the new position back to a character
                char encryptedChar = (char) ('a' + newPos);
                result.append(encryptedChar);
            } else {
                // Append non-lowercase characters unchanged
                result.append(c);
            }
        }
        return result.toString();
    }
}