package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_163 {
    public static List<Integer> generateIntegers(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = a; i <= Math.min(b + 1, 10); i++) {
            if (i % 2 == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateIntegers(2, 8)); // [2, 4, 6, 8]
        System.out.println(generateIntegers(8, 2)); // [2, 4, 6, 8]
        System.out.println(generateIntegers(10, 14)); // []
    }
}