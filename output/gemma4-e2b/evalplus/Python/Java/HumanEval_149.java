package com.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_149 {
    public static List<String> sortedListSum(List<String> lst) {
        // 1. Filter: delete strings that have odd lengths (keep even length strings)
        List<String> filteredList = lst.stream()
                                      .filter(s -> s.length() % 2 == 0)
                                      .collect(Collectors.toList());

        // 2. Sort: ascending by length, then alphabetically
        filteredList.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Sort by length ascending
                int lengthComparison = Integer.compare(s1.length(), s2.length());
                if (lengthComparison != 0) {
                    return lengthComparison;
                }
                // If lengths are equal, sort alphabetically
                return s1.compareTo(s2);
            }
        });

        return filteredList;
    }
}