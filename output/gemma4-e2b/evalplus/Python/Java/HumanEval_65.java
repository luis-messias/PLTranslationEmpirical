package com.example;
class Solution {
    public String circularShift(int x, int shift) {
        String s = String.valueOf(x);
        int n = s.length();

        if (shift > n) {
            // If shift > number of digits, return digits reversed.
            return new StringBuilder(s).reverse().toString();
        }

        // Calculate effective shift
        int effectiveShift = shift % n;

        if (effectiveShift == 0) {
            return s;
        } else {
            // Perform right circular shift: s[n - effectiveShift:] + s[:n - effectiveShift]
            String part1 = s.substring(n - effectiveShift);
            String part2 = s.substring(0, n - effectiveShift);
            return part1 + part2;
        }
    }
}