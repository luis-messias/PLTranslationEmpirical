package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_29 {
    /**
     * Filter an input list of strings only for ones that start with a given prefix.
     * @param strings The list of strings to filter.
     * @param prefix The prefix to check against.
     * @return A new list containing only the strings that start with the given prefix.
     */
    public static List<String> filterByPrefix(List<String> strings, String prefix) {
        return strings.stream()
                .filter(s -> s.startsWith(prefix))
                .collect(Collectors.toList());
    }
}