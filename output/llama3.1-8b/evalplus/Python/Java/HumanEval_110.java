package com.example;
import java.util.*;

public class HumanEval_110 {
    public static String exchange(int[] lst1, int[] lst2) {
        int cntOdd = 0;
        for (int num : lst1) {
            if (num % 2 == 1) {
                cntOdd++;
            }
        }
        int cntEven = 0;
        for (int num : lst2) {
            if (num % 2 == 0) {
                cntEven++;
            }
        }
        return cntOdd <= cntEven ? "YES" : "NO";
    }

    public static void main(String[] args) {
        int[] lst1 = {1, 2, 3, 4};
        int[] lst2 = {1, 5, 3, 4};
        System.out.println(exchange(lst1, lst2));
    }
}