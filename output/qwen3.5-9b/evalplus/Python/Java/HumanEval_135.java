package com.example;
public class HumanEval_135 {
    public int canArrange(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                return i;
            }
        }
        return -1;
    }
}