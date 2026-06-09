package com.example;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HumanEval_58 {
    
    public static List<Integer> common(List<Integer> l1, List<Integer> l2) {
        Set<Integer> setL1 = new HashSet<>(l1);
        Set<Integer> setL2 = new HashSet<>(l2);

        return Arrays.asList(setL1.stream().sorted(Integer::compareTo).collect(Collectors.toCollection(() -> list -> {return list;})));
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 4, 3, 34, 653, 2, 5);
        List<Integer> list2 = Arrays.asList(5, 7, 1, 5, 9, 653, 121);

        System.out.println(common(list1, list2)); // Output: [1, 5, 653]

        List<Integer> list3 = Arrays.asList(5, 3, 2, 8);
        List<Integer> list4 = Arrays.asList(3, 2);

        System.out.println(common(list3, list4)); // Output: [2, 3]
    }
}
