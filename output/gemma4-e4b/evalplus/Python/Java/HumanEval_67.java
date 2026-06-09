package com.example;
class Solution {
    public static int fruitDistribution(String s, int n) {
        String[] words = s.split(" ");
        
        // c1 is the number of apples (words[0])
        int c1 = Integer.parseInt(words[0]);
        
        // c2 is the number of oranges (words[3])
        int c2 = Integer.parseInt(words[3]);
        
        // Replicating the assertion check (though usually handled by caller/design)
        if (n - c1 - c2 < 0) {
            throw new IllegalArgumentException("invalid inputs");
        }
        
        return n - c1 - c2;
    }
}