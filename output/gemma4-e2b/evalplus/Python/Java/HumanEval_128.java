package com.example;
class Solution {
    public static Object prodSigns(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        // Check if 0 is present, if so, return 0 immediately
        for (int x : arr) {
            if (x == 0) {
                return 0;
            }
        }

        long sumOfMagnitudes = 0;
        int productOfSigns = 1;

        for (int x : arr) {
            sumOfMagnitudes += Math.abs(x);
            
            // Calculate the sign: x / |x|
            // Since we checked for 0, this is safe.
            int currentSign = x / Math.abs(x);
            productOfSigns *= currentSign;
        }

        // The result is (sum of magnitudes) * (product of signs)
        return sumOfMagnitudes * productOfSigns;
    }
}