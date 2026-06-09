package com.example;

import java.util.Arrays;
import java.util.Comparator;

public class HumanEval_116 {

    public static void main(String[] args) {
        int[][] result = sort2DArray(new int[][]{{1}, {5}, {2}, {3}, {4}});
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] sort2DArray(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] a, int[] b) {
                String binA = Integer.toBinaryString(a[0]);
                String binB = Integer.toBinaryString(b[0]);

                int onesCountA = (int) binA.replace("1", "").length();
                int onesCountB = (int) binB.replace("1", "").length();

                if(onesCountA != onesCountB)
                    return Math.abs(onesCountA - onesCountB);

                else
                    return Integer.compare(a[0], b[0]);

            }
        });

        return arr;
    }

}
