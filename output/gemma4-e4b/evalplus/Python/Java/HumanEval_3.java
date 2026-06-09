package com.example;
import java.util.List;

class Solution {
    /**
     * You're given a list of deposit and withdrawal operations on a bank account that starts with
     * zero balance. Your task is to detect if at any point the balance of account fallls below zero, and
     * at that point function should return True. Otherwise it should return False.
     *
     * @param operations A list of deposit and withdrawal operations.
     * @return True if the balance ever falls below zero, False otherwise.
     */
    public static boolean belowZero(List<Integer> operations) {
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