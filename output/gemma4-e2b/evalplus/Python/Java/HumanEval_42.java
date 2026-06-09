package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_42 {
    /**
     * Return list with elements incremented by 1.
     * @param l The input list of integers.
     * @return A new list where each element is incremented by 1.
     */
    public static List<Integer> incrList(List<Integer> l) {
        List<Integer> result = new ArrayList<>();
        for (int x : l) {
            result.add(x + 1);
        }
        return result;
    }
}