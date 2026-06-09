package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String stringSequence(int n) {
        List<String> parts = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            parts.add(String.valueOf(i));
        }
        return String.join(" ", parts.toArray(new String[0]));
    }
}