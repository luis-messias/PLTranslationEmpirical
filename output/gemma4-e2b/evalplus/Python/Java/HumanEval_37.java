package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static List<Integer> sortEven(List<Integer> l) {
        int n = l.size();
        if (n == 0) {
            return new ArrayList<>();
        }

        // 1. Extract elements at even indices
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            even.add(l.get(i));
        }

        // 2. Sort the extracted elements
        Collections.sort(even);

        // 3. Construct the result list
        List<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // Even index: place the next sorted even element
                // The index in 'even' is i / 2
                result.add(even.get(i / 2));
            } else {
                // Odd index: keep the original value
                result.add(l.get(i));
            }
        }
        return result;
    }
}