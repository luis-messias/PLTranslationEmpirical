package com.example;
import java.util.*;

public class HumanEval_149 {
    public static List<String> sortedListSum(List<String> lst) {
        return lst.stream()
                .filter(s -> s.length() % 2 == 0)
                .sorted((s1, s2) -> {
                    int lenCompare = Integer.compare(s1.length(), s2.length());
                    if (lenCompare != 0) {
                        return lenCompare;
                    } else {
                        return s1.compareTo(s2);
                    }
                })
                .toList();
    }

    public static void main(String[] args) {
        List<String> lst = new ArrayList<>(Arrays.asList("aa", "a", "aaa"));
        System.out.println(sortedListSum(lst));
        
        lst = new ArrayList<>(Arrays.asList("ab", "a", "aaa", "cd"));
        System.out.println(sortedListSum(lst));
    }
}