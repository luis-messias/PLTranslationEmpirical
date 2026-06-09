package com.example;
class Solution {
    public int[] evenOddCount(int num) {
        int even = 0;
        int odd = 0;
        String s = String.valueOf(num);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Check if the character is a digit and determine parity
            if (ch == '0' || ch == '2' || ch == '4' || ch == '6' || ch == '8') {
                even++;
            } else if (ch == '1' || ch == '3' || ch == '5' || ch == '7' || ch == '9') {
                odd++;
            }
        }
        return new int[]{even, odd};
    }
}