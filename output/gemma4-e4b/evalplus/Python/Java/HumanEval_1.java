package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Input to this function is a string containing multiple groups of nested parentheses. Your goal is to
     * separate those group into separate strings and return the list of those.
     * Separate groups are balanced (each open brace is properly closed) and not nested within each other
     * Ignore any spaces in the input string.
     *
     * @param parenString The input string containing parentheses groups.
     * @return A list of strings, where each string is a separate balanced group.
     */
    public List<String> separateParenGroups(String parenString) {
        int cnt = 0;
        StringBuilder group = new StringBuilder();
        List<String> results = new ArrayList<>();

        for (char ch : parenString.toCharArray()) {
            if (ch == '(') {
                cnt++;
            } else if (ch == ')') {
                cnt--;
            }

            if (ch != ' ') {
                group.append(ch);
            }

            // Check if a balanced group is completed
            if (cnt == 0) {
                String currentGroup = group.toString();
                if (!currentGroup.isEmpty()) {
                    results.add(currentGroup);
                    group.setLength(0); // Reset group
                }
            }
        }
        return results;
    }
}