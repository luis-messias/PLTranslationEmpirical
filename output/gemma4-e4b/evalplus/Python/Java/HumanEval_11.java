package com.example;
class Solution {
    public static String stringXor(String a, String b) {
        StringBuilder result = new StringBuilder();
        int length = a.length();

        for (int i = 0; i < length; i++) {
            // Convert character '0' or '1' to integer 0 or 1
            int bitA = a.charAt(i) - '0';
            int bitB = b.charAt(i) - '0';

            // Perform XOR
            int xorResult = bitA ^ bitB;

            // Append the result
            result.append(xorResult);
        }

        return result.toString();
    }
}