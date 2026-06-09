package com.example;
class Solution {
    public boolean triplesSumToZero(int[] l) {
        int n = l.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    if (l[i] + l[j] + l[k] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}