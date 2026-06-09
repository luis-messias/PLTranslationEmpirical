package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_7 {
    /**
     * Filter an input list of strings only for ones that contain given substring
     * @param strings The list of strings to filter.
     * @param substring The substring to search for.
     * @return A new list containing only the strings that include the substring.
     */
    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}