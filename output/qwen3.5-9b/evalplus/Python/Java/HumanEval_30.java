package com.example;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class HumanEval_30 {
    /**
     * Return only positive numbers in the list.
     * @param l the input list of integers
     * @return a list containing only positive numbers
     */
    public static List<Integer> getPositive(List<Integer> l) {
        return l.stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
    }
}