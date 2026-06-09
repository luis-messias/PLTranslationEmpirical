package com.example;
import java.util.*;

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

        if (numbers.isEmpty()) return "";
        List<String> list = Arrays.asList(numbers.split("\\s+"));
        Collections.sort(list, (n1, n2) -> toInt.get(n1).compareTo(toInt.get(n2)));
        return String.join(" ", list);
    }
}