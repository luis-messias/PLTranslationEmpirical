package com.example;
import java.util.List;

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
        Integer negResult;

        if (!neg.isEmpty()) {
            negResult = Collections.max(neg);
        } else {
            negResult = -1; // sentinel value indicating no negative integers
        }

        result[0] = (Integer) negResult;
        
        boolean hasPositiveInt = false;
        for (int num : lst) {
            if (num > 0 && posMin == null || num < posMin) {
                posMin = num;
                hasPositiveInt = true;
            }
        }

        Integer posResult;

        if (!hasPositiveInt || posMax == null || posMax <= 0) { // No positive numbers found.
            posResult = -1; // sentinel value indicating no smallest positive integer
        } else {
            posResult = Collections.min(pos);
        }

        result[1] = (Integer) posResult;

        return result;
    }
}
