package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> parseNestedParens(String parenString) {
        String[] groups = parenString.split(" ");
        List<Integer> results = new ArrayList<>();

        for (String s : groups) {
            if (s.isEmpty()) {
                continue;
            }

            int maxDepth = 0;
            int currentCount = 0;

            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    currentCount++;
                } else if (ch == ')') {
                    currentCount--;
                }
                maxDepth = Math.max(maxDepth, currentCount);
            }
            results.add(maxDepth);
        }

        return results;
    }
}