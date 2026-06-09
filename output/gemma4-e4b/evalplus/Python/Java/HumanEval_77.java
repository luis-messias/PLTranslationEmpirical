package com.example;
class Solution {
    /**
     * Checks if the given long integer 'a' is a perfect cube of some integer.
     * @param a The input integer.
     * @return True if 'a' is a perfect cube, False otherwise.
     */
    public boolean iscube(long a) {
        // Calculate the cube root of 'a'
        double cbrt = Math.cbrt(a);
        
        // Round the cube root to the nearest long integer
        // Math.round(double) returns a long
        long root = Math.round(cbrt);
        
        // Check if root * root * root equals the original number 'a'
        // We use long arithmetic to prevent overflow during cubing.
        long result = root * root * root;
        
        return result == a;
    }
}