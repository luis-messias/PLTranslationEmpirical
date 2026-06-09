package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_35 {
    public static Integer maxElement(List<Integer> list) {
        if (list.stream().allMatch(x -> x instanceof Integer)) {
            return list.stream().max(Integer::compare).orElse(null);
        } else {
            throw new IllegalArgumentException("invalid inputs");
        }
    }

    public static void main(String[] args) {
        System.out.println(maxElement(List.of(1, 2, 3)));
        System.out.println(maxElement(List.of(5, 3, -5, 2, -3, 3, 9, 0, 123, 1, -10)));
    }
}