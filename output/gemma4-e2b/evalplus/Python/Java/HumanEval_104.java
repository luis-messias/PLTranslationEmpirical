package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> uniqueDigits(List<Integer> x) {
        List<Integer> result = new ArrayList<>();

        for (int num : x) {
            if (hasNoEvenDigits(num)) {
                result.add(num);
            }
        }

        Collections.sort(result);
        return result;
    }

    private boolean hasNoEvenDigits(int n) {
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            // Convert character digit to integer
            int digit = s.charAt(i) - '0';
            
            // Check if the digit is even
            if (digit % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}