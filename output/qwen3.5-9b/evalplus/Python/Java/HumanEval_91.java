package com.example;
public static int is_bored(String S) {
    if (S == null || S.isEmpty()) {
        return 0;
    }
    
    // Replace '?' and '!' with '.'
    String modifiedS = S.replace("?", ".").replace("!", ".");
    
    // Split by '.'
    String[] sentences = modifiedS.split("\\.");
    
    int count = 0;
    for (String s : sentences) {
        // Strip whitespace
        s = s.trim();
        // Check if starts with "I "
        if (s.length() > 0 && s.startsWith("I ")) {
            count++;
        }
    }
    
    return count;
}