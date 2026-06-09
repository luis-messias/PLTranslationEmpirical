package com.example;
public class HumanEval_50 {

    public static String encodeShift(String input) {
        StringBuilder encoded = new StringBuilder();
        
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                int shifted = ((ch - base + 5) % 26);
                encoded.append((base + shifted));
            } else {
                encoded.append(ch); // Non-letter characters are not changed
            }
        }

        return encoded.toString();
    }

    public static String decodeShift(String input) {
        StringBuilder decoded = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                int shifted = ((ch - base - 5 + 26) % 26);
                decoded.append((base + shifted));
            } else {
                decoded.append(ch); // Non-letter characters are not changed
            }
        }

        return decoded.toString();
    }

}