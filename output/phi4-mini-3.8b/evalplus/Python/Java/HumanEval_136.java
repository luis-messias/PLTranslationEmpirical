package com.example;
import java.util.List;
import java.util.ArrayList;

public class HumanEval_136 {

    public static int[] largest_smallest_integers(List<Integer> lst) {
        List<Integer> neg = new ArrayList<>();
        for (int num : lst) {
            if (num < 0) {
                neg.add(num);
            }
        }

        Integer posMin = null;
        Integer posMax = null;

        for (Integer num : lst) {
            if (num > 0 && (posMin == null || num < posMin)) {
                posMin = num;
            } else if (num <= 0 && (posMax == null || num > posMax)) {
                posMax = num;
            }
        }

        int[] result = new int[2];
        if (!neg.isEmpty()) {
            result[0] = neg.stream().max((a, b) -> Integer.compare(a, b)).get();
        } else {
            result[0] = null; // or any sentinel value indicating no negative integers
        }

        if (posMin != null && posMax == null || posMin > 0) { // No positive numbers found.
            result[1] = posMin;
        } else {
            result[1] = null; // Sentinel for not having a smallest positive integer or all are zero/negative
        }

        return result;
    }
}