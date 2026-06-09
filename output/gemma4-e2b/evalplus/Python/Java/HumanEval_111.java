package com.example;
import java.util.HashMap;
import java.util.Map;

public class HumanEval_111 {
    public static Map<String, Integer> histogram(String test) {
        if (test == null || test.isEmpty()) {
            return new HashMap<>();
        }

        // Step 1 & 2: Count frequencies
        Map<String, Integer> count = new HashMap<>();
        
        // Split the string by space. We use trim() to handle potential leading/trailing spaces 
        // and then split. If the input is just spaces, split might produce empty strings, 
        // but the Python code handles empty strings resulting from split implicitly 
        // by checking `if word != ""`.
        String[] words = test.split(" ");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }

        if (count.isEmpty()) {
            return new HashMap<>();
        }

        // Step 3: Find the maximum count
        int mx = 0;
        for (int c : count.values()) {
            if (c > mx) {
                mx = c;
            }
        }

        // Step 4: Collect all letters with the maximum count
        Map<String, Integer> ans = new HashMap<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() == mx) {
                ans.put(entry.getKey(), entry.getValue());
            }
        }

        return ans;
    }
}