package com.example;
class Solution {
    public int hexKey(String num) {
        int count = 0;
        String primeDigits = "2357BD";

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (primeDigits.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}