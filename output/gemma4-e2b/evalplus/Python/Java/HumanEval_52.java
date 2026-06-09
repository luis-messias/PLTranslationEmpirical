package com.example;
import java.util.List;

class Solution {
    public boolean belowThreshold(List<Integer> l, int t) {
        for (int x : l) {
            if (x >= t) {
                return false;
            }
        }
        return true;
    }
}