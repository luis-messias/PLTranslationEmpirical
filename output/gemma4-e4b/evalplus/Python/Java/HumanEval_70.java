package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static List<Integer> strangeSortList(List<Integer> lst) {
        if (lst == null || lst.isEmpty()) {
            return new ArrayList<>();
        }

        // Create a sorted copy of the input list
        List<Integer> sortedList = new ArrayList<>(lst);
        Collections.sort(sortedList);

        List<Integer> ans = new ArrayList<>();
        int i = 0; // Pointer for minimum
        int j = sortedList.size() - 1; // Pointer for maximum

        // Loop until the pointers meet or cross
        while (i < j) {
            // Append minimum
            ans.add(sortedList.get(i));
            // Append maximum
            ans.add(sortedList.get(j));
            
            i++;
            j--;
        }

        // Handle the middle element if the list size is odd
        if (i == j) {
            ans.add(sortedList.get(i));
        }

        return ans;
    }
}