package com.example;
class Solution {
    /**
     * Counts the number of hexadecimal digits in the string that correspond to prime numbers: 2, 3, 5, 7, B (11), D (13).
     * 
     * @param num The hexadecimal number string.
     * @return The count of prime hexadecimal digits.
     */
    public int hexKey(String num) {
        int count = 0;
        // The set of prime hexadecimal digits (as characters)
        String primeDigits = "2357BD"; 

        for (char c : num.toCharArray()) {
            // Check if the character c is present in the primeDigits string
            if (primeDigits.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}