package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    /**
     * This function takes a list l and returns a list l' such that
     * l' is identical to l in the odd indices, while its values at the even indices are equal
     * to the values of the even indices of l, but sorted.
     *
     * @param l The input list of integers.
     * @return The modified list.
     */
    public static List<Integer> sortEven(List<Integer> l) {
        if (l == null || l.isEmpty()) {
            return new ArrayList<>();
        }

        // 1. Extract elements at even indices
        List<Integer> evenElements = new ArrayList<>();
        for (int i = 0; i < l.size(); i += 2) {
            evenElements.add(l.get(i));
        }

        // 2. Sort the extracted elements
        Collections.sort(evenElements);

        // 3. Construct the result list
        List<Integer> result = new ArrayList<>(l.size());
        for (int i = 0; i < l.size(); i++) {
            if (i % 2 == 0) {
                // Even index: use the sorted value
                // The element at index i corresponds to the (i/2)-th element in the sorted list.
                int sortedIndex = i / 2;
                result.add(evenElements.get(sortedIndex));
            } else {
                // Odd index: keep the original value
                result.add(l.get(i));
            }
        }
        return result;
    }
}