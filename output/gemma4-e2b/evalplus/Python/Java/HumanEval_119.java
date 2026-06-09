package com.example;
class Solution {
    private boolean validParens(String s) {
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                cnt++;
            } else if (ch == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }

    public String match_parens(String[] lst) {
        if (lst == null || lst.length != 2) {
            // Handle invalid input if necessary, though constraints usually guarantee valid input structure.
            // Based on the Python code, we assume lst has exactly two strings.
            return "No"; 
        }

        String s1 = lst[0];
        String s2 = lst[1];

        // Check concatenation order s1 + s2
        if (validParens(s1 + s2)) {
            return "Yes";
        }

        // Check concatenation order s2 + s1
        if (validParens(s2 + s1)) {
            return "Yes";
        }

        return "No";
    }
}