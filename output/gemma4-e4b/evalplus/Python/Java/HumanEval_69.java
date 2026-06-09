package com.example;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

class Solution {
    /**
     * You are given a non-empty list of positive integers. Return the greatest integer that is greater than 
     * zero, and has a frequency greater than or equal to the value of the integer itself. 
     * The frequency of an integer is the number of times it appears in the list.
     * If no such a value exist, return -1.
     */
    public int search(List<Integer> lst) {
        // 1. Count frequencies
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : lst) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 2. Find the greatest integer satisfying the condition
        int ans = -1;
        
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            
            // Check the condition: frequency >= number
            if (cnt >= num) {
                // Update ans to be the maximum found so far
                if (num > ans) {
                    ans = num;
                }
            }
        }
        
        return ans;
    }
}