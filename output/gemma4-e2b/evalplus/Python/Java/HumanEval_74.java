package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_74 {
    public static List<String> totalMatch(List<String> lst1, List<String> lst2) {
        // Calculate the total number of characters in lst1
        long c1 = lst1.stream().mapToLong(String::length).sum();

        // Calculate the total number of characters in lst2
        long c2 = lst2.stream().mapToLong(String::length).sum();

        // Return lst1 if c1 <= c2, otherwise return lst2
        if (c1 <= c2) {
            return lst1;
        } else {
            return lst2;
        }
    }
}