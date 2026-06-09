package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_9 {
    public static List<Integer> rollingMax(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        int n = numbers.size();

        for (int i = 0; i < n; i++) {
            // Calculate the maximum of the prefix numbers[0] to numbers[i]
            List<Integer> prefix = numbers.subList(0, i + 1);
            
            // Find the maximum element in the prefix
            int currentMax = prefix.stream()
                                 .mapToInt(Integer::intValue)
                                 .max()
                                 .orElse(Integer.MIN_VALUE); // Should not happen if list is non-empty

            result.add(currentMax);
        }
        return result;
    }
}