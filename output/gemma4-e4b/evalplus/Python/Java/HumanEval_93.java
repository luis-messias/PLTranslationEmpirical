package com.example;
class CodeTranslator {

    /**
     * Encodes a message by swapping the case of all letters and replacing 
     * all vowels with the letter two places ahead in the alphabet.
     * Assumes only letters are present (though the logic handles non-letters).
     * 
     * @param message The input string.
     * @return The encoded string.
     */
    public static String encode(String message) {
        // Step 1: Case Switching
        StringBuilder sb1 = new StringBuilder();
        for (char c : message.toCharArray()) {
            char switchedChar = c;
            if (c >= 'A' && c <= 'Z') {
                // Uppercase to lowercase
                switchedChar = Character.toLowerCase(c);
            } else if (c >= 'a' && c <= 'z') {
                // Lowercase to uppercase
                switchedChar = Character.toUpperCase(c);
            }
            sb1.append(switchedChar);
        }
        String m = sb1.toString();

        // Step 2: Vowel Changing
        StringBuilder sb2 = new StringBuilder();
        for (char c : m.toCharArray()) {
            char finalChar = c;
            
            if (isVowel(c)) {
                // Advance by 2. This relies on the assumption that the resulting 
                // character remains within the alphabet range.
                finalChar = (char