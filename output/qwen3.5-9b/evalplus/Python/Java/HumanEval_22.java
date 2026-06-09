package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_22 {
    public static List<Integer> filterIntegers(List<Object> values) {
        return values.stream()
            .filter(x -> x instanceof Integer)
            .collect(Collectors.toList());
    }
}