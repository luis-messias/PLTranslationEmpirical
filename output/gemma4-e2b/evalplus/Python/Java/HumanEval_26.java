package com.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanEval_26 {
    public static List<Integer> removeDuplicates(List<Integer> numbers) {
        // Step 1: Count the occurrences of each number
        Map<Integer, Integer> numCnt = new HashMap<>();
        for (int number : numbers) {
            numCnt.put(number, numCnt.getOrDefault(number, 0) + 1);
        }

        // Step 2: Filter the original list, keeping only elements that occur exactly once
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            if (numCnt.get(number) == 1) {
                result.add(number);
            }
        }

        return result;
    }
}