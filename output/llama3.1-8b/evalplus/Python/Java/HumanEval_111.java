package com.example;
import java.util.*;

public class HumanEval_111 {
    public static Map<String, Integer> histogram(String test) {
        if (test.isEmpty()) return new HashMap<>();
        
        Map<String, Integer> count = new HashMap<>();
        for (String word : test.split(" ")) {
            if (!word.isEmpty()) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }
        
        int mx = Collections.max(count.values());
        Map<String, Integer> ans = new HashMap<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() == mx) {
                ans.put(entry.getKey(), entry.getValue());
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(histogram("a b c"));
        System.out.println(histogram("a b b a"));
        System.out.println(histogram("a b c a b"));
        System.out.println(histogram("b b b b a"));
        System.out.println(histogram(""));
    }
}