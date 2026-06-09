package com.example;
import java.util.List;

class Solution {
    /**
     * triplesSumToZero takes a list of integers as an input.
     * It returns true if there are three distinct elements in the list that
     * sum to zero, and false otherwise.
     *
     * @param l The list of integers.
     * @return true if a triplet sums to zero, false otherwise.
     */
    public boolean triplesSumToZero(List<Integer> l) {
        int n = l.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    // Calculate the sum. Since l contains Integer objects,
                    // Java handles the unboxing for arithmetic operations.
                    int sum = l.get(i) + l.get(j) + l.get(k);
                    if (sum == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}