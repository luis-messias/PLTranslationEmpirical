package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> makeAPile(int n) {
        List<Integer> ans = new ArrayList<>();
        int num = n;
        
        for (int i = 0; i < n; i++) {
            ans.add(num);
            num += 2;
        }
        return ans;
    }
}