package com.example;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class HumanEval_42 {
    public static List<Integer> incrList(List<Integer> l) {
        return l.stream()
                .map(x -> x + 1)
                .collect(Collectors.toList());
    }
}