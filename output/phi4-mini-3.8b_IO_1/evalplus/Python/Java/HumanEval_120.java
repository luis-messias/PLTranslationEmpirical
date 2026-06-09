package com.example;
import java.util.Arrays;

public class HumanEval_120 {

    public static int[] maximum(int[] arr, int k) {
        // Sort array in descending order and then slice it up to length k.
        return Arrays.copyOfRange(Arrays.stream(arr).sorted(Collections.reverseOrder()).toArray(), 0, Math.min(k, arr.length));
    }

}
