package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_28 {
    public static String concatenate(List<String> strings) {
        return strings.stream().collect(Collectors.joining());
    }
}