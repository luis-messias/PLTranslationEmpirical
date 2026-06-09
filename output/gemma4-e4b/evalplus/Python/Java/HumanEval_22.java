package com.example;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HumanEval_22 {
    /**
     * Filter given list of any python values only for integers
     * @param values The list of values to filter.
     * @return A list containing only the integers from the input list.
     */
    public static List<Integer> filterIntegers(List<?> values) {
        return values.stream()
                .filter(value -> value instanceof Integer)
                .map(value -> (Integer) value)
                .collect(Collectors.toList());
    }
}