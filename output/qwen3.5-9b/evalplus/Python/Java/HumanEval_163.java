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
        for (int i = a; i < Math.min(b + 1, 10); i++) {
            if (i % 2 == 0) {
                result.add(i);
            }
        }
        return result;
    }
}