package com.example;

import java.util.Collections;
import java.util.List;

public class HumanEval_90 {

    public static Integer nextSmallest(List<Integer> lst) {
        if (lst == null || lst.size() <= 1) return null;

        List<Integer> sortedList = new ArrayList<>(Collections.nCopies(lst.size(), -Integer.MAX_VALUE));
        for (int i : lst) {
            int index = Collections.binarySearch(sortedList, i);
            if (index < 0) { // element not found
                index = -(index + 1); 
            }
            sortedList.set(index, i);
        }

        Integer firstMin = null;
        Integer secondMin = null;

        for (Integer num : sortedList) {
            if (firstMin == null || num < firstMin) {
                secondMin = firstMin;
                firstMin = num;
            } else if ((secondMin == null) || (num < secondMin)) {
                secondMin = num;
            }
        }

        return secondMin != null ? new Integer(secondMin) : null;
    }

    public static void main(String[] args) {

        System.out.println(nextSmallest(List.of(1, 2, 3, 4, 5))); // Should print: 2

        System.out.println(nextSmallest(List.of(5, 1, 4, 3, 2))); // Should print: 2

        System.out.println(nextSmallest(Collections.emptyList())); // Should print: null

        System.out.println(nextSmallest(List.of(1, 1))); // Should print: null
    }
}
