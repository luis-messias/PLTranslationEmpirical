package com.example;
import java.util.*;

public class HumanEval_68 {
    public static List<Integer> pluck(int[] arr) {
        if (Arrays.stream(arr).allMatch(x -> x % 2 == 1)) return new ArrayList<>();
        int minEven = Arrays.stream(arr).filter(x -> x % 2 == 0).min().getAsInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == minEven) return Arrays.asList(minEven, i);
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, 3};
        System.out.println(pluck(arr1)); // [2, 1]

        int[] arr2 = {1, 2, 3};
        System.out.println(pluck(arr2)); // [2, 1]

        int[] arr3 = {};
        System.out.println(pluck(arr3)); // []

        int[] arr4 = {5, 0, 3, 0, 4, 2};
        System.out.println(pluck(arr4)); // [0, 1]
    }
}