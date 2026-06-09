package com.example;
import java.util.HashSet;
import java.util.Set;

public class HumanEval_158 {
    public static String findMax(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        int maxChCnt = -1;
        String ans = "";

        for (String word : words) {
            // Calculate the number of unique characters
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : word.toCharArray()) {
                uniqueChars.add(c);
            }
            int chCnt = uniqueChars.size();

            // Check if this word is better than the current best answer
            if (chCnt > maxChCnt) {
                maxChCnt = chCnt;
                ans = word;
            } else if (chCnt == maxChCnt) {
                // Tie-breaker: choose the lexicographically smaller word
                if (word.compareTo(ans) < 0) {
                    ans = word;
                }
            }
        }
        return ans;
    }
}