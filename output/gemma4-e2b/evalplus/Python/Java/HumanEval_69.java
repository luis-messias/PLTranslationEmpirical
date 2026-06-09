package com.example;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int search(List<Integer> lst) {
        // 1. Count frequencies
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : lst) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int ans = -1;
        
        // 2. Find the greatest integer satisfying the condition
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            
            // Check if frequency (cnt) is greater than or equal to the number itself (num)
            if (cnt >= num) {
                if (num > ans) {
                    ans = num;
                }
            }
        }
        
        return ans;
    }
}