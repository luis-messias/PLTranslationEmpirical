package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_22 {

    public static void main(String[] args) {
        System.out.println(filterIntegers(new String[]{"a", "3.14", "5"}));
        List<Object> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add("'abc'");
        values.add(null); // Added null to match the original Python code
        System.out.println(filterIntegers(values.toArray(new Object[0])));
    }

    public static <T> List<Integer> filterIntegers(T[] values) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (Object value : values) {
            if (value instanceof Integer) {
                integers.add((Integer) value);
            }
        }
        return integers;
    }
}
