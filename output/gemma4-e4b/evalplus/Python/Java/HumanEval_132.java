package com.example;
class Solution {
    public static boolean isNested(String string) {
        int n = string.length();

        for (int i = 0; i < n; i++) {
            // Skip if the starting character is ']'
            if (string.charAt(i) == ']') {
                continue;
            }

            int cnt = 0;
            int maxNest = 0;

            for (int j = i; j < n; j++) {
                char c = string.charAt(j);

                if (c == '[') {
                    cnt++;
                } else { // c == ']'
                    cnt--;
                }

                // Update max nesting depth
                maxNest = Math.max(maxNest, cnt);

                // Check if a balanced subsequence is formed
                if (cnt == 0) {
                    if (maxNest >= 2) {
                        return true;
                    }
                    // Found a balanced segment, break the inner loop and try the next starting point i
                    break;
                }
            }
        }
        return false;
    }
}