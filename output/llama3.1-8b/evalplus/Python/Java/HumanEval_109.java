package com.example;
import java.util.Arrays;

public class HumanEval_109 {
    public static boolean moveOneBall(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        if (Arrays.equals(arr, sortedArr)) return true;
        for (int i = 1; i < arr.length; i++) {
            if (java.util.Arrays.equals(java.util.Arrays.copyOfRange(arr, i, arr.length), java.util.Arrays.copyOfRange(sortedArr, 0, sortedArr.length - i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 1, 2};
        System.out.println(moveOneBall(arr1)); // prints: true

        int[] arr2 = {3, 5, 4, 1, 2};
        System.out.println(moveOneBall(arr2)); // prints: false
    }
}