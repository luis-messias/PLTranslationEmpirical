package com.example;
import java.util.*;

public class HumanEval_34 {
    public static List<Integer> unique(List<Integer> l) {
        Set<Integer> set = new HashSet<>(l);
        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 5, 2, 3, 3, 9, 0, 123);
        System.out.println(unique(list));
    }
}
