package com.example;
import java.util.*;

public class HumanEval_40 {
    public static boolean triplesSumToZero(int[] l) {
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l.length; j++) {
                for (int k = 0; k < l.length; k++) {
                    if (i != j && i != k && j != k && l[i] + l[j] + l[k] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(triplesSumToZero(new int[]{1, 3, 5, 0})); // False
        System.out.println(triplesSumToZero(new int[]{1, 3, -2, 1})); // True
        System.out.println(triplesSumToZero(new int[]{1, 2, 3, 7})); // False
        System.out.println(triplesSumToZero(new int[]{2, 4, -5, 3, 9, 7})); // True
        System.out.println(triplesSumToZero(new int[]{1})); // False
    }
}