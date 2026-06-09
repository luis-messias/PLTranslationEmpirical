package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> intersperse(List<Integer> numbers, int delimiter) {
        List<Integer> res = new ArrayList<>();
        int length = numbers.size();

        for (int i = 0; i < length; i++) {
            res.add(numbers.get(i));
            if (i < length - 1) {
                res.add(delimiter);
            }
        }
        return res;
    }
}