package com.example;
class Solution {
    public static int fruitDistribution(String s, int n) {
        String[] words = s.split(" ");
        
        // Based on the examples, the structure is always: "X apples and Y oranges"
        // words[0] is X (apples)
        // words[3] is Y (oranges)
        
        int c1 = Integer.parseInt(words[0]); // Apples
        int c2 = Integer.parseInt(words[3]); // Oranges
        
        // Calculate mango fruits: Total - Apples - Oranges
        return n - c1 - c2;
    }
}