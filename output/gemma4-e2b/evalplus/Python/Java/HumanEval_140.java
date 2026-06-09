package com.example;
class Solution {
    public String fixSpaces(String text) {
        String ans = text;
        int len = text.length();
        
        // The Python loop iterates i from len down to 3 (since range(len, 2, -1) stops before 2)
        for (int i = len; i >= 3; i--) {
            // Construct the string of i spaces to search for
            String spacesToFind = "";
            for (int j = 0; j < i; j++) {
                spacesToFind += " ";
            }
            // Replace all occurrences of i consecutive spaces with a hyphen