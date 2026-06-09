package com.example;
class Solution {
    public static boolean cycpattern_check(String a, String b) {
        if (a.equals(b)) {
            return true;
        }
        if (b.isEmpty()) {
            return true;
        }

        int n = b.length();
        String sA = a;

        for (int i = 0; i < n; i++) {
            // Generate rotation: b[i:] + b[:i]
            String rotation = b.substring(i) + b.substring(0, i);
            
            // Check if rotation is a substring of a
            if (sA.contains(rotation)) {
                return true;
            }
        }
        return false;
    }
}