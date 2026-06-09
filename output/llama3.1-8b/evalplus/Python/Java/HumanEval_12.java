package com.example;
import java.util.List;
import java.util.Optional;

public class HumanEval_12 {
    public static Optional<String> longest(List<String> strings) {
        if (strings.isEmpty()) {
            return Optional.empty();
        }

        int maxlen = strings.stream().mapToInt(String::length).max().orElse(0);
        for (String s : strings) {
            if (s.length() == maxlen) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }
}