package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static List<Integer> sortThird(List<Integer> l) {
        int n = l.size();
        
        // 1. Collect elements at indices divisible by 3
        List<Integer> third = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0) {
                third.add(l.get(i));
            }
        }
        
        // 2. Sort the collected elements
        Collections.sort(third);
        
        // 3. Build the result list
        List<Integer> result = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0) {
                // Index i is divisible by 3. The sorted value is at index i/3 in the 'third' list.
                int sortedIndex = i / 3;
                result.add(third.get(sortedIndex));
            } else {
                // Index i is not divisible by 3. Keep the original value.
                result.add(l.get(i));
            }
        }
        
        return result;
    }
}