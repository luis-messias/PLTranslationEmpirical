package com.example;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    /**
     * Finds the second smallest unique element in the list.
     * Returns null if there is no such element (list is too small, or all elements are identical).
     */
    public Integer nextSmallest(List<Integer> lst) {
        if (lst == null || lst.size() <= 1) {
            return null;
        }

        // Create a sorted copy of the list
        List<Integer> sortedList = new ArrayList<>(lst);
        Collections.sort(sortedList);

        Integer smallest = sortedList.get(0);

        // Iterate through the sorted list starting from the second element
        for (int i = 1; i < sortedList.size(); i++) {
            Integer current = sortedList.get(i);
            
            // Check if the current element is different from the smallest element
            if (!current.equals(smallest)) {
                return current;
            }
        }

        // If the loop completes, all elements were identical
        return null;
    }
}