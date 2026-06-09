package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_30 {
    public static List<Integer> getPositive(List<Integer> l) {
        return l.stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
    }
}