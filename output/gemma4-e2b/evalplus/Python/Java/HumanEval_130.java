package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> tri(int n) {
        if (n == 0) {
            return List.of(1);
        }
        if (n == 1) {
            return List.of(1, 3);
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(3);

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                // tri(i) = 1 + i / 2
                ans.add(1 + i / 2);
            } else {
                // tri(i) = tri(i - 1) + tri(i - 2) + 1 + (i + 1) / 2
                int last = ans.get(ans.size() - 1);
                int secondLast = ans