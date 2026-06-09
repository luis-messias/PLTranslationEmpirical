package com.example;
import java.util.List;
import java.util.ArrayList;

public class HumanEval_9 {
    public static List<Integer> rollingMax(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                max = Math.max(max, numbers.get(j));
            }
            result.add(max);
        }
        return result;
    }
}