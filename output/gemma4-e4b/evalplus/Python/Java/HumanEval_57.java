package com.example;
import java.util.List;

class Solution {
    /**
     * Return True if list elements are monotonically increasing or decreasing.
     * @param l The list of integers.
     * @return True if the list is monotonic, False otherwise.
     */
    public boolean monotonic(List<Integer> l) {
        if (l == null || l.size() <= 1) {
            return true;
        }

        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < l.size() - 1; i++) {
            int current = l.get(i);
            int next = l.get(i + 1);

            // Check for violation of non-decreasing (monotonically increasing)
            if (current > next) {
                inc = false;
            }
            
            // Check for violation of non-increasing (monotonically decreasing)
            if (current < next) {
                dec = false;
            }
        }
        
        return inc || dec;
    }
}