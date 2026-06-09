package com.example;
import java.util.*;

public class HumanEval_7 {
    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static void main(String[] args) {
        System.out.println(filterBySubstring(Arrays.asList("abc", "bacd", "cde", "array"), "a"));
    }
}