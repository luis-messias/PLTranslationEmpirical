package com.example;
class CodeTranslator {

    /**
     * returns encoded string by shifting every character by 5 in the alphabet.
     * Assumes input contains only lowercase English letters.
     */
    public static String encodeShift(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            // Calculate the 0-indexed position (0-25)
            int originalIndex = ch - 'a';
            
            // Apply the shift and wrap around using modulo 26
            int newIndex = (originalIndex + 5) % 26;
            
            // Convert the new index back to a character
            char newChar = (char) (newIndex + 'a');
            sb.append(newChar);
        }
        return sb.toString();
    }

    /**
     * takes as input string encoded with encodeShift function. Returns decoded string.
     * Assumes input contains only lowercase English letters.
     */
    public static String decodeShift(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            // Calculate the 0-indexed position (0-25)
            int originalIndex = ch - 'a';
            
            // Apply the reverse shift (-5). Adding 26 ensures the numerator is positive 
            // before the modulo operation, handling potential negative results correctly.
            int newIndex = (originalIndex - 5 + 26) % 26;
            
            // Convert the new index back to a character
            char newChar = (char) (newIndex + 'a');
            sb.append(newChar);
        }
        return sb.toString();
    }
}