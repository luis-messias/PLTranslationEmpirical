package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Calculates the maximum depth of nesting for a given parentheses string.
     * @param s The parentheses string.
     * @return The maximum depth.
     */
    private int countDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                currentDepth++;
            } else if (ch == ')') {
                currentDepth--;
            }
            // Update maxDepth after processing the character
            maxDepth = Math.max(maxDepth, currentDepth);
        }
        return maxDepth;
    }

    /**
     * Input to this function is a string represented multiple groups for nested parentheses separated by spaces.
     * For each of the group, output the deepest level of nesting of parentheses.
     * E.g. (()()) has maximum two levels of nesting while ((())) has three.
     * 
     * @param parenString The input string containing space-separated groups.
     * @return A list of integers representing the maximum nesting depth for each group.
     */
    public List<Integer> parseNestedParens(String parenString) {
        List<Integer> results = new ArrayList<>();
        
        // Split by one or more whitespace characters to handle multiple spaces between groups
        String[] groups = parenString.split("\\s+");
        
        for (String group : groups) {
            // Check if the group is not empty (this handles cases where the input might start/end with spaces)
            if (!group.isEmpty()) {
                results.add(countDepth(group));
            }
        }
        return results;
    }
}