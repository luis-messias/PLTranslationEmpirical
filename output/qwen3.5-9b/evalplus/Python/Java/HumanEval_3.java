package com.example;
import java.util.List;

public class HumanEval_3 {
    /**
     * You're given a list of deposit and withdrawal operations on a bank account that starts with
     * zero balance. Your task is to detect if at any point the balance of account falls below zero, and
     * at that point function should return true. Otherwise it should return false.
     * 
     * @param operations List of deposit (positive) and withdrawal (negative) operations
     * @return true if balance falls below zero at any point, false otherwise
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