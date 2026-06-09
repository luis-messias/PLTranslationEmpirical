package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_70 {
    public static List<Integer> strangeSortList(List<Integer> lst) {
        if (lst == null || lst.isEmpty()) {
            return new ArrayList<>();
        }

        // Create a mutable copy and sort it
        List<Integer> sortedList = new ArrayList<>(lst);
        Collections.sort(sortedList);

        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = sortedList.size() - 1;

        // Alternate taking the smallest and largest remaining elements
        while (i < j) {
            ans.add(sortedList.get(i));
            ans.add(sortedList.get(j));
            i++;
            j--;
        }

        // If there is a middle element left (only happens if list length is odd)
        if (i == j) {
            ans.add(sortedList.get(i));
        }

        return ans;
    }
}