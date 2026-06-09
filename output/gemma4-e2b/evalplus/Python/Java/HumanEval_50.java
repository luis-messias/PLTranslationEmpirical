package com.example;
class ShiftEncoder {
    /**
     * returns encoded string by shifting every character by 5 in the alphabet.
     */
    public static String encodeShift(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            // Calculate position relative to 'a' (0-25)
            int originalPos = ch - 'a';
            // Shift by 5 and wrap around 26
            int newPos = (originalPos + 5) % 26;
            // Convert back to character
            char newChar = (char) (newPos + 'a');
            result.append(newChar);
        }
        return result.toString();
    }

    /**
     * takes as input string encoded with encode_shift function. Returns decoded string.
     */
    public static String decodeShift(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            // Calculate position relative to 'a' (0-25)
            int originalPos = ch - 'a';
            // Shift back by 5. Add 26 before modulo to handle negative results correctly.
            int newPos = (originalPos - 5 + 26) % 26;
            // Convert back to character
            char newChar = (char) (newPos + 'a');
            result.append(newChar);
        }
        return result.toString();
    }
}