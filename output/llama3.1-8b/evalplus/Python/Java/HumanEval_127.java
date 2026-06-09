package com.example;
import java.util.Arrays;

public class HumanEval_127 {
    public static String intersection(int[] interval1, int[] interval2) {
        boolean isPrime = (int) Math.sqrt(interval2[0] - interval1[0]) < 2;
        for (int i = 3; i <= (int) Math.sqrt(interval2[0] - interval1[0]); i += 2) {
            if ((interval2[0] - interval1[0]) % i == 0) isPrime = false;
        }
        return isPrime ? "YES" : "NO";
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}};
        System.out.println(intersection(intervals[0], intervals[1])); // NO
        intervals = new int[][]{{-1, 1}, {0, 4}};
        System.out.println(intersection(intervals[0], intervals[1])); // NO
        intervals = new int[][]{{-3, -1}, {-5, 5}};
        System.out.println(intersection(intervals[0], intervals[1])); // YES
    }
}