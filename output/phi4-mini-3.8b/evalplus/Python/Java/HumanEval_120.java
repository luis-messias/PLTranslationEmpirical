package com.example;
import java.util.Arrays;
import java.util.Collections;

public class HumanEval_120 {

    public static int[] maximum(int[] arr, int k) {
        // Sort array in descending order and then slice it up to length k.
        return Arrays.copyOfRange(Arrays.stream(arr).sorted(Collections.reverseOrder()).toArray(), 0, Math.min(k, arr.length));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maximum(new int[]{-3, -4, 5}, 3))); // Output: [-4, -3, 5]
        System.out.println(Arrays.toString(maximum(new int[]{4, -4, 4}, 2)));   // Output: [4, 4]
        System.out.println(Arrays.toString(maximum(new int[]{-3, 2, 1, 2, -1, -2, 1}, 1))); // Output: [2]
    }
}