package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class HumanEval_42 {
    public static List<Integer> incrList(List<Integer> l) {
        return l.stream()
                .map(x -> x + 1)
                .collect(Collectors.toList());
    }

    // Example usage (optional, for testing purposes)
    public static void main(String[] args) {
        // Test case 1
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        System.out.println(incrList(list1)); // Expected: [2, 3, 4]

        // Test case 2
        List<Integer> list2 = Arrays.asList(5, 3, 5, 2, 3, 3, 9, 0, 123);
        System.out.println(incrList(list2)); // Expected: [6, 4, 6, 3, 4, 4, 10, 1, 124]
    }
}