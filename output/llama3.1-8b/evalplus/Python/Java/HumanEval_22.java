package com.example;
import java.util.*;

public class HumanEval_22 {
    public static List<Integer> filterIntegers(List<Object> values) {
        return values.stream()
                .filter(x -> x instanceof Integer)
                .map(x -> (Integer)x)
                .collect(Collectors.toList());
    }
}