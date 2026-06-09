package com.example;
import java.util.Arrays;

public class HumanEval_47 {
    public static double median(int[] l) {
        Arrays.sort(l);
        if (l.length % 2 == 1) {
            return l[l.length / 2];
        } else {
            return (l[l.length / 2 - 1] + l[l.length / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] test1 = {3, 1, 2, 4, 5};
        System.out.println(median(test1));

        int[] test2 = {-10, 4, 6, 1000, 10, 20};
        System.out.println(median(test2));
    }
}