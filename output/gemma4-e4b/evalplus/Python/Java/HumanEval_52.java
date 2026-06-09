package com.example;
import java.util.List;

class Solution {
    /**
     * Return True if all numbers in the list l are below threshold t.
     * @param l The list of integers.
     * @param t The threshold.
     * @return True if all numbers in l are less than t, False otherwise.
     */
    public static boolean belowThreshold(List<Integer> l, int t) {
        for (int x : l) {
            if (x >= t) {
                return false;
            }
        }
        return true;
    }
}