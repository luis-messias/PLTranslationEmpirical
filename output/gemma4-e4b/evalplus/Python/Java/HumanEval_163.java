package com.example;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

class Solution {
    public List<Integer> generateIntegers(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        List<Integer> result = new ArrayList<>();
        
        // Determine the upper bound (exclusive), mimicking min(b + 1, 10)
        int limit = Math.min(b + 1, 10);

        for (int i = a; i < limit; i++) {
            if (i % 2 == 0) {
                result.add(i);
            }
        }
        return result;
    }
}