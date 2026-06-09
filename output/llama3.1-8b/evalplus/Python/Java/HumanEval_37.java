package com.example;
import java.util.Arrays;

public class HumanEval_37 {
    public static int[] sortEven(int[] l) {
        int[] even = new int[l.length / 2];
        for (int i = 0; i < l.length; i++) {
            if (i % 2 == 0) {
                even[i / 2] = l[i];
            }
        }
        Arrays.sort(even);
        int[] result = new int[l.length];
        for (int i = 0; i < l.length; i++) {
            if (i % 2 == 0) {
                result[i] = even[i / 2];
            } else {
                result[i] = l[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        System.out.println(Arrays.toString(sortEven(test1)));

        int[] test2 = {5, 6, 3, 4};
        System.out.println(Arrays.toString(sortEven(test2)));
    }
}