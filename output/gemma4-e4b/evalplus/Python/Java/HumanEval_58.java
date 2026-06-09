package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HumanEval_58 {
    public static List<Integer> common(List<Integer> l1, List<Integer> l2) {
        Set<Integer> set1 = new HashSet<>(l1);
        Set<Integer> set2 = new HashSet<>(l2);
        
        set1.retainAll(set2);
        
        List<Integer> result = new ArrayList<>(set1);
        Collections.sort(result);
        return result;
    }
}