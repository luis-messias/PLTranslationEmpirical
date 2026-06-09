package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_52 {
    public static boolean belowThreshold(List<Integer> list, int threshold) {
        return list.stream().allMatch(x -> x < threshold);
    }

    public static void main(String[] args) {
        System.out.println(belowThreshold(List.of(1, 2, 4, 10), 100)); // true
        System.out.println(belowThreshold(List.of(1, 20, 4, 10), 5));   // false
    }
}