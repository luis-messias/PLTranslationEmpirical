package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_29 {
    public static List<String> filterByPrefix(List<String> strings, String prefix) {
        return strings.stream()
                .filter(s -> s.startsWith(prefix))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(filterByPrefix(new ArrayList<>(), "a"));
        System.out.println(filterByPrefix(List.of("abc", "bcd", "cde", "array"), "a"));
    }
}