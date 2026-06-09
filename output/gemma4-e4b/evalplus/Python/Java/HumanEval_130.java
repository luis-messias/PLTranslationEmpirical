package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> tri(int n) {
        List<Integer> ans = new ArrayList<>();

        if (n == 0) {
            ans.add(1);
            return ans;
        }
        if (n == 1) {
            ans.add(1);
            ans.add(3);
            return ans;
        }

        // Initialize ans with the first two elements (for i=0 and i=1)
        ans.add(1); // Index 0
        ans.add(3); // Index 1

        // Loop from i=2 up to n
        for (int i = 2; i