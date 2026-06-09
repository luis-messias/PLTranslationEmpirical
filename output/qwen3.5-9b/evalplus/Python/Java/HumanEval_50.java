package com.example;
public class HumanEval_50 {
    /**
     * Returns encoded string by shifting every character by 5 in the alphabet.
     */
    public static String encodeShift(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            char encoded = (char) ((ch - 'a' + 5) % 26 + 'a');
            result.append(encoded);
        }
        return result.toString();
    }

    /**
     * Takes as input string encoded with encodeShift function. Returns decoded string.
     */
    public static String decodeShift(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            char decoded = (char) ((ch - 'a' - 5 + 26) % 26 + 'a');
            result.append(decoded);
        }
        return result.toString();
    }
}