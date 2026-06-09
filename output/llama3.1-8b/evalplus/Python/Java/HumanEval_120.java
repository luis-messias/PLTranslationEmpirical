package com.example;
import java.util.Arrays;

public class HumanEval_120 {
    public static int[] maximum(int[] arr, int k) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - k; i++) {
            arr[i] = arr[arr.length - k + i];
        }
        return Arrays.copyOfRange(arr, arr.length - k, arr.length);
    }

    public static void main(String[] args) {
        int[] arr1 = {-3, -4, 5};
        int[] result1 = maximum(arr1, 3);
        System.out.println(Arrays.toString(result1));

        int[] arr2 = {4, -4, 4};
        int[] result2 = maximum(arr2, 2);
        System.out.println(Arrays.toString(result2));

        int[] arr3 = {-3, 2, 1, 2, -1, -2, 1};
        int[] result3 = maximum(arr3, 1);
        System.out.println(Arrays.toString(result3));
    }
}