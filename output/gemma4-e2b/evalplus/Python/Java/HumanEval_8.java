package com.example;
import java.util.List;

class Solution {
    public static int[] sumProduct(List<Integer> numbers) {
        long sum = 0;
        long product = 1;

        for (int number : numbers) {
            sum += number;
            product *= number;
        }

        return new int[]{(int) sum, (int) product};
    }
}