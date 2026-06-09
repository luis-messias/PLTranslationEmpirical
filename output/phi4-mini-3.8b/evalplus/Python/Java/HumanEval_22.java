package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_22 {

    public static void main(String[] args) {
        System.out.println(filterIntegers(new String[]{"a", "3.14", "5"}));
        System.out.println(filterIntegers(List.of(1, 2, 3, "'abc'", new Object(), List.of())));
    }

    public static <T> List<Integer> filterIntegers(T[] values) {
        List<Integer> integers = new ArrayList<>();
        for (Object value : values) {
            if (value instanceof Integer) {
                integers.add((Integer) value);
            }
        }
        return integers;
    }
}