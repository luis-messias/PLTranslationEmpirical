package com.example;
import java.util.*;

public class HumanEval_58 {
    public static List<Integer> common(List<Integer> l1, List<Integer> l2) {
        /**
         * Return sorted unique common elements for two lists.
         * @param l1 first list
         * @param l2 second list
         * @return sorted list of unique common elements
         */
        Set<Integer> set1 = new HashSet<>(l1);
        Set<Integer> set2 = new HashSet<>(l2);
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        List<Integer> result = new ArrayList<>(intersection);
        Collections.sort(result);
        return result;
    }
}