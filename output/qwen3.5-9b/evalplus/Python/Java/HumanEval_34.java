package com.example;
import java.util.*;

public class HumanEval_34 {
    /**
     * Return sorted unique elements in a list
     * @param l the input list
     * @return sorted unique elements
     */
    public static List<Integer> unique(List<Integer> l) {
        Set<Integer> set = new HashSet<>(l);
        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
}