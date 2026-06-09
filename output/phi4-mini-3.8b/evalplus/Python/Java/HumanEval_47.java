package com.example;
import java.util.Arrays;

public class HumanEval_47 {

    public static double median(int[] l) {
        Arrays.sort(l);
        int len = l.length;
        if (len % 2 == 1)
            return Double.valueOf(l[len / 2]);
        else
            return ((double)l[(len - 1) / 2] + (double)l[len / 2]) / 2.0;
    }

    public static void main(String[] args) {
        int[] list = {3, 1, 2, 4, 5};
        System.out.println(median(list)); // Output: 3

        int[] anotherList = {-10, 4, 6, 1000, 10, 20};
        System.out.println(median(anotherList)); // Output: 15.0
    }
}