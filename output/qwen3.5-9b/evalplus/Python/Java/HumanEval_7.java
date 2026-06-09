package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_7 {
    /**
     * Filter an input list of strings only for ones that contain given substring
     * @param strings the list of strings to filter
     * @param substring the substring to search for
     * @return a list containing only strings that contain the given substring
     */
    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
            .filter(s -> s.contains(substring))
            .collect(Collectors.toList());
    }
}