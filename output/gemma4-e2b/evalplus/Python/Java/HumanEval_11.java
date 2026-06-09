package com.example;
class Solution {
    public String stringXor(String a, String b) {
        if (a.length() != b.length()) {
            // Depending on requirements, handle error or throw exception. 
            // Assuming inputs are of equal length based on the Python context.
        }
        
        StringBuilder result = new StringBuilder();
        int n = a.length();
        
        for (int i = 0; i < n; i++) {
            // Convert char '0' or '1' to integer 0 or 1
            int bitA = a.charAt(i) - '0';
            int bitB = b.charAt(i) - '0';
            
            // Perform XOR
            int xorResult = bitA ^ bitB;
            
            // Append the result (0 or 1) as a character
            result.append(xorResult);
        }
        
        return result.toString();
    }
}