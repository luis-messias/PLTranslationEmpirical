package com.example;
import java.util.*;
import java.util.stream.Collectors;

public class HumanEval_58 {
    public static List<Integer> common(List<Integer> l1, List<Integer> l2) {
        Set<Integer> set1 = new HashSet<>(l1);
        Set<Integer> set2 = new HashSet<>(l2);

        // Find the intersection of the two sets
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Convert the intersection set to a list and sort it
        List<Integer> result = new ArrayList<>(intersection);
        Collections.sort(result);

        return result;
    }
}