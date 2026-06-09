package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> intersperse(List<Integer> numbers, int delimiter) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            res.add(numbers.get(i));
            if (i != numbers.size() - 1) {
                res.add(delimiter);
            }
        }
        return res;
    }
}