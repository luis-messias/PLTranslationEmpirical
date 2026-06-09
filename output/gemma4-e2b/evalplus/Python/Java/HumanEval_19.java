package com.example;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HumanEval_19 {
    public static String sortNumbers(String numbers) {
        Map<String, Integer> toInt = new HashMap<>();
        toInt.put("zero", 0);
        toInt.put("one", 1);
        toInt.put("two", 2);
        toInt.put("three", 3);
        toInt.put("four", 4);
        toInt.put("five", 5);
        toInt.put("six", 6);
        toInt.put("seven", 7);
        toInt.put("eight", 8);
        toInt.put("nine", 9);

        if (numbers == null || numbers.isEmpty()) {
            return "";
        }

        String[] parts = numbers.split(" ");

        Arrays.sort(parts, (a, b) -> {
            int valA = toInt.get(a);
            int valB = toInt.get(b);
            return Integer.compare(valA, valB);
        });

        return String.join(" ", parts);
    }
}