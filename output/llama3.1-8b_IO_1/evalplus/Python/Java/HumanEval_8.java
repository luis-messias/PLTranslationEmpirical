package com.example;

import java.util.List;
import java.util.stream.IntStream;

public class HumanEval_8 {
    public static void main(String[] args) {
        System.out.println(sumProduct(List.of(1, 2, 3, 4)));
        System.out.println(sumProduct(List.of()));
    }

    public static int[] sumProduct(List<Integer> numbers) {
        int s = 0;
        int p = 1;

        for (int number : numbers) {
            s += number;
            p *= number;
        }
        
        return new int[]{s, p};
    }
}
