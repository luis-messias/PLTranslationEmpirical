package com.example;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    /**
     * Given an array arr of integers and a positive integer k, return a sorted array 
     * of length k with the maximum k numbers in arr.
     * 
     * @param arr The input array.
     * @param k The number of largest elements to return.
     * @return An array containing the k largest elements, sorted in ascending order.
     */
    public int[] maximum(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        // 1. Sort the array in ascending order.
        // This places the smallest elements at the beginning and the largest at the end.
        Arrays.sort(arr);

        // 2. The k largest elements are the last k elements of the sorted array.
        // We need to copy these elements into a new array of size k.
        int[] result = new int[k];
        
        // Calculate the starting index for the k largest elements.
        int startIndex = arr.length - k;
        
        // Copy the elements from arr[startIndex] to arr[arr.length - 1] into result[0] to result[k-1].
        System.arraycopy(arr, startIndex, result, 0, k);
        
        return result;
    }
}