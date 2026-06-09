package com.example;
import java.util.List;

class Solution {
    
    private static int strength(String s) {
        int CAP = 0;
        int SM = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                CAP++;
            } else if (Character.isLowerCase(ch)) {
                SM++;
            }
        }
        return CAP - SM;
    }

    public String StrongestExtension(String className, List<String> extensions) {
        if (extensions == null || extensions.isEmpty()) {
            return "";
        }

        // 1. Find the maximum strength
        int maxStrength = Integer.MIN_VALUE;
        
        for (String extension : extensions) {
            int currentStrength = strength(extension);
            if (currentStrength > maxStrength) {
                maxStrength = currentStrength;
            }
        }
        
        // 2. Find the first extension that matches maxStrength
        for (String extension : extensions) {
            if (strength(extension) == maxStrength) {
                return className + "." + extension;
            }
        }
        
        // Fallback, though theoretically unreachable if extensions is not empty
        return ""; 
    }
}