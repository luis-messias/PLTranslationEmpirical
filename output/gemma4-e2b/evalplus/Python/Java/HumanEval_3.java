package com.example;
import java.util.List;

class Solution {
    public boolean belowZero(List<Integer> operations) {
        int account = 0;
        for (int operation : operations) {
            account += operation;
            if (account < 0) {
                return true;
            }
        }
        return false;
    }
}