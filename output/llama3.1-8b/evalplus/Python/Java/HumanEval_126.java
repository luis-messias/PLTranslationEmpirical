package com.example;
import java.util.*;

public class HumanEval_126 {
    public static boolean isSorted(int[] lst) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : lst) {
            if (!count.containsKey(x)) count.put(x, 0);
            count.put(x, count.get(x) + 1);
            if (count.get(x) > 2) return false;
        }
        Arrays.sort(lst);
        return Arrays.equals(lst, sortedArray(lst));
    }

    private static int[] sortedArray(int[] arr) {
        int[] result = new int[arr.length];
        System.arraycopy(arr, 0, result, 0, arr.length);
        Arrays.sort(result);
        return result;
    }
}