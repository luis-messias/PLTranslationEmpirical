package com.example;
class Solution {
    public String circularShift(int x, int shift) {
        String s = String.valueOf(x);
        int len = s.length();

        // If shift > number of digits, return digits reversed.
        if (shift > len) {
            return new StringBuilder(s).reverse().toString();
        }

        // Calculate effective shift
        int effectiveShift = shift % len;

        // If effective shift is 0, return original string.
        if (effectiveShift == 0) {
            return s;
        } else {
            // The split point is len - effectiveShift
            int splitIndex = len - effectiveShift;

            // Part 1: The last 'effectiveShift' characters (s[len - effectiveShift:])
            String part1 = s.substring(splitIndex);

            // Part 2: The first 'len - effectiveShift' characters (s[:len - effectiveShift])
            String part2 = s.substring(0, splitIndex);

            return part1 + part2;
        }
    }
}