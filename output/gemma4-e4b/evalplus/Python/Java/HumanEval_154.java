package com.example;
class Solution {
    /**
     * You are given 2 words. You need to return True if the second word or any of its rotations is a substring in the first word
     * cycpattern_check("abcd","abd") => False
     * cycpattern_check("hello","ell") => True
     * cycpattern_check("whassup","psus") => False
     * cycpattern_check("abab","baa") => True
     * cycpattern_check("efef","eeff") => False
     * cycpattern_check("himenss","simen") => True
     */
    public boolean cycpattern_check(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Input strings cannot be null");
        }

        if (a.equals(b)) {
            return true;
        }
        if (b.isEmpty()) {
            return true;
        }

        int lenB = b.length();
        for (int i = 0; i < lenB; i++) {
            // Generate rotation: b[i:] + b[:i]
            String rotatedB = b.substring(i) + b.substring(0, i);
            if (a.contains(rotatedB)) {
                return true;
            }
        }
        return false;
    }
}