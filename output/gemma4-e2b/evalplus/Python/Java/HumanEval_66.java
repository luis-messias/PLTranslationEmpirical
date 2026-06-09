package com.example;
class Solution {
    public int digitSum(String s) {
        int sum = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                sum += ch; // In Java, adding a char to an int promotes the char to its ASCII integer value.
            }
        }
        return sum;
    }
}