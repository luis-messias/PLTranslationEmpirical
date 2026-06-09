package com.example;
public class HumanEval_122 {
    public int addElements(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            if (hasAtMostTwoDigits(arr[i])) {
                sum += arr[i];
            }
        }
        return sum;
    }
    
    private boolean hasAtMostTwoDigits(int x) {
        String s = String.valueOf(Math.abs(x));
        return s.length() <= 2;
    }
}