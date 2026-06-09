package com.example;
class Solution {
    public static boolean monotonic(int[] l) {
        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < l.length - 1; i++) {
            if (l[i] > l[i + 1]) {
                inc = false;
            }
            if (l[i] < l[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }
}