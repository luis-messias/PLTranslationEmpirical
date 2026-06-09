package com.example;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public int solution(List<Integer> lst) {
        int sum = 0;
        for (int i = 0; i < lst.size(); i++) {
            // Check if the position (index i) is even (0, 2, 4, ...)
            // Note: The problem description implies 1-based indexing for "even positions"
            // but the provided Python solution uses 0-based indexing for "even positions" (i % 2 == 0).
            // Assuming the Python logic (0-based index i is even) is the intended behavior.
            if (i % 2 == 0) {
                int element = lst.get(i);
                // Check if the element is odd
                if (element % 2 != 0) {
                    sum += element;
                }
            }
        }
        return sum;
    }
}