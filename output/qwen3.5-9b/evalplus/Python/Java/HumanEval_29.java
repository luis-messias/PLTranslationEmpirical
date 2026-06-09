package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_29 {
    /**
     * Filter an input list of strings only for ones that start with a given prefix.
     * @param strings the input list of strings
     * @param prefix the prefix to filter by
     * @return a list of strings that start with the given prefix
     */
    public static List<String> filterByPrefix(List<String> strings, String prefix) {
        return strings.stream()
            .filter(s -> s.startsWith(prefix))
            .collect(Collectors.toList());
    }
}