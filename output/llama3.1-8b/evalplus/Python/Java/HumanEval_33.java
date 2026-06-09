package com.example;
import java.util.Arrays;

public class HumanEval_33 {
    public static int[] sortThird(int[] l) {
        int[] third = new int[l.length / 3];
        for (int i = 0; i < l.length; i++) {
            if (i % 3 == 0) {
                third[i / 3] = l[i];
            }
        }
        Arrays.sort(third);
        int[] result = new int[l.length];
        for (int i = 0; i < l.length; i++) {
            if (i % 3 == 0) {
                result[i] = third[i / 3];
            } else {
                result[i] = l[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        int[] test2 = {5, 6, 3, 4, 8, 9, 2};

        System.out.println(Arrays.toString(sortThird(test1)));
        System.out.println(Arrays.toString(sortThird(test2)));
    }
}