package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HumanEval_34 {
    /**
     * Return sorted unique elements in a list
     * @param l The input list of integers.
     * @return A list containing the unique elements of l, sorted in ascending order.
     */
    public static List<Integer> unique(List<Integer> l) {
        Set<Integer> uniqueElements = new HashSet<>(l);
        List<Integer> result = new ArrayList<>(uniqueElements);
        Collections.sort(result);
        return result;
    }
}