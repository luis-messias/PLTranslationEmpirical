package com.example;
import java.util.Arrays;

public class HumanEval_90 {
    public static Integer next_smallest(int[] lst) {
        if (lst.length <= 1) return null;
        int[] sorted_list = lst.clone();
        Arrays.sort(sorted_list);
        for (int x : sorted_list) {
            if (x != sorted_list[0]) {
                return x;
            }
        }
        return null;
    }
}