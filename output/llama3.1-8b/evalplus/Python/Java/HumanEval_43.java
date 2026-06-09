package com.example;
import java.util.*;

public class HumanEval_43 {
    public static boolean pairsSumToZero(int[] l) {
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l.length; j++) {
                if (i != j && l[i] + l[j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] testCases = {{1, 3, 5, 0}, {1, 3, -2, 1}, {1, 2, 3, 7}, {2, 4, -5, 3, 5, 7}, {1}};
        
        for (int[] testCase : testCases) {
            System.out.println(pairsSumToZero(testCase));
        }
    }
}