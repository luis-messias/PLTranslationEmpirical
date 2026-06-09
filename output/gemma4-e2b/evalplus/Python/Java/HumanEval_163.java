package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> generateIntegers(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int limit = Math.min(b + 1, 10);
        List<Integer> result = new ArrayList<>();

        for (int i = a; i < limit; i++) {
            if (i % 2 == 0) {
                result.add(i);
            }
        }
        return result;
    }
}