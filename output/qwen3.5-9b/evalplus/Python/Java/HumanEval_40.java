package com.example;
import java.util.List;

public class HumanEval_40 {
    /**
     * triplesSumToZero takes a list of integers as an input.
     * it returns True if there are three distinct elements in the list that
     * sum to zero, and False otherwise.
     *
     * @param l list of integers
     * @return true if three distinct elements sum to zero, false otherwise
     */
    public static boolean triplesSumToZero(List<Integer> l) {
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < l.size(); j++) {
                for (int k = 0; k < l.size(); k++) {
                    if (i != j && i != k && j != k && l.get(i) + l.get(j) + l.get(k) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}