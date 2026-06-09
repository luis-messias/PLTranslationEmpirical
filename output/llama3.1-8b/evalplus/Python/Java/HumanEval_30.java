package com.example;
import java.util.*;

public class HumanEval_30 {
    public static List<Integer> getPositive(List<Integer> l) {
        return l.stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(-1, 2, -4, 5, 6);
        System.out.println(getPositive(list1));

        List<Integer> list2 = Arrays.asList(5, 3, -5, 2, -3, 3, 9, 0, 123, 1, -10);
        System.out.println(getPositive(list2));
    }
}