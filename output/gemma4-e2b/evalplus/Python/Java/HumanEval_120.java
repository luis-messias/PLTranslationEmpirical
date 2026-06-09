package com.example;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> maximum(int[] arr, int k) {
        // Sort the array in ascending order
        Arrays.sort(arr);
        
        int n = arr.length;
        
        // The k largest elements are the last k elements of the sorted array.
        // We extract them into a new list. Since the original array was sorted, 
        // the extracted elements will also be in sorted order.
        List<Integer> result = new ArrayList<>();
        
        // Start index is n - k
        for (int i = n - k; i < n; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}