package com.example;
import java.util.List;

class Solution {
    public boolean pairsSumToZero(List<Integer> l) {
        int n = l.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (l.get(i) + l.get(j) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}