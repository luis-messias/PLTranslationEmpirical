package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    /**
     * Given an array of integers, sorts the entire array, reverses the sorted order,
     * filters elements between 1 and 9, and replaces them with their corresponding names.
     *
     * @param arr The input array of integers.
     * @return An array of strings representing the names of the filtered digits.
     */
    public String[] byLength(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new String[0];
        }

        // 1. Create a copy and sort it (ascending order)
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        List<String> resultList = new ArrayList<>();
        int n = sortedArr.length;

        // 2. Iterate backwards (Reversed sorted order)
        for (int i = n - 1; i >= 0; i--) {
            int x = sortedArr[i];

            // 3. Filter: check if 1 <= x <= 9
            if (x >= 1 && x <= 9) {
                // 4. Map and append
                resultList.add(toWord(x));
            }
        }

        // 5. Convert List<String> to String[]
        return resultList.toArray(new String[0]);
    }

    private String toWord(int x) {
        switch (x) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: