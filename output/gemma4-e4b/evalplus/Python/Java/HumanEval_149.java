package com.example;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    public List<String> sortedListSum(List<String> lst) {
        return lst.stream()
                // 1. Filter: Keep strings with even length
                .filter(s -> s.length() % 2 == 0)
                // 2. Sort: Primary key = length (ascending), Secondary key = alphabetical (ascending)
                .sorted(Comparator.comparingInt(String::length)
                                  .thenComparing(Comparator.naturalOrder()))
                // 3. Collect results
                .collect(Collectors.toList());
    }
}