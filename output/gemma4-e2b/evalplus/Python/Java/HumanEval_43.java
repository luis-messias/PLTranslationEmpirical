package com.example;
class Solution {
    public static boolean pairsSumToZero(int[] l) {
        int n = l.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && l[i] + l[j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}