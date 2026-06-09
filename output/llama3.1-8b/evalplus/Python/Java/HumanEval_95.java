package com.example;
import java.util.*;

public class HumanEval_95 {
    public static boolean checkDictCase(Map<String, String> dict) {
        if (dict.isEmpty()) return false;
        Set<String> keys = dict.keySet();
        boolean lower = true, upper = true;
        for (String k : keys) {
            if (!k.getClass().equals(String.class)) {
                lower = upper = false;
                break;
            }
            if (!k.toLowerCase().equals(k)) lower = false;
            if (!k.toUpperCase().equals(k)) upper = false;
        }
        return lower || upper;
    }

    public static void main(String[] args) {
        Map<String, String> dict1 = new HashMap<>();
        dict1.put("a", "apple");
        dict1.put("b", "banana");
        System.out.println(checkDictCase(dict1)); // prints: true

        Map<String, String> dict2 = new HashMap<>();
        dict2.put("a", "apple");
        dict2.put("A", "banana");
        dict2.put("B", "banana");
        System.out.println(checkDictCase(dict2)); // prints: false
    }
}