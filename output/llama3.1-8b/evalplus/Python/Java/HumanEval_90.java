package com.example;
import java.util.Arrays;

public class HumanEval_90 {
    public static Integer nextSmallest(Integer[] lst) {
        if (lst.length <= 1) return null;
        Arrays.sort(lst);
        for (Integer x : lst) {
            if (!x.equals(lst[0])) {
                return x;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(nextSmallest(new Integer[]{1, 2, 3, 4, 5})); // 2
        System.out.println(nextSmallest(new Integer[]{5, 1, 4, 3, 2})); // 2
        System.out.println(nextSmallest(new Integer[]{})); // null
        System.out.println(nextSmallest(new Integer[]{1, 1})); // null
    }
}