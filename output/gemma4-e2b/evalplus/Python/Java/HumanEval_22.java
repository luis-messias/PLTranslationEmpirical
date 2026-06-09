package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_22 {
    public List<Integer> filterIntegers(List<?> values) {
        return values.stream()
                .filter(x -> x instanceof Integer)
                .map(x -> (Integer) x)
                .collect(Collectors.toList());
    }
}