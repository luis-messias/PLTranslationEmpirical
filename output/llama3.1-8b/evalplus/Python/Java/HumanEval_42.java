package com.example;
import java.util.Arrays;

public class HumanEval_42 {
    public static int[] incrList(int[] l) {
        int[] result = new int[l.length];
        for (int i = 0; i < l.length; i++) {
            result[i] = l[i] + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        System.out.println(Arrays.toString(incrList(test1)));

        int[] test2 = {5, 3, 5, 2, 3, 3, 9, 0, 123};
        System.out.println(Arrays.toString(incrList(test2)));
    }
}