package com.example;
import java.util.List;
import java.util.ArrayList;

public class HumanEval_42 {

    public static List<Integer> incr_list(List<Integer> l) {
        List<Integer> result = new ArrayList<>();
        for (Integer x : l) {
            result.add(x + 1);
        }
        return result;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(incr_list(new ArrayList<>(java.util.Arrays.asList(1, 2, 3))));
        System.out.println(incr_list(new ArrayList<>(java.util.Arrays.asList(5, 3, 5, 2, 3, 3, 9, 0, 123))));
    }
}