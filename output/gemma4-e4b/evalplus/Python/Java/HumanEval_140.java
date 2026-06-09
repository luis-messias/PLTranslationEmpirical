package com.example;
class Solution {
    public String fixSpaces(String text) {
        // First, replace sequences of 3 or more spaces with "-"
        String ans = text.replaceAll(" {3,}", "-");
        
        // Then, replace all remaining single spaces with "_"
        return ans.replaceAll(" ", "_");
    }
}