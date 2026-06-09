package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_130 {
    public static List<Integer> tri(int n) {
        if (n == 0) return new ArrayList<>(List.of(1));
        if (n == 1) return new ArrayList<>(List.of(1, 3));
        List<Integer> ans = new ArrayList<>(List.of(1, 3));
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                ans.add((int)(1 + i / 2));
            } else {
                ans.add(ans.get(ans.size() - 1) + ans.get(ans.size() - 2) + (int)(1 + (i + 1) / 2));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(tri(3)); // [1, 3, 2, 8]
    }
}