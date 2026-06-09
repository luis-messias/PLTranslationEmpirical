package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_106 {
    public static List<Integer> f(int n) {
        if (n == 0) return new ArrayList<>();
        if (n == 1) return List.of(1);
        if (n == 2) return List.of(1, 2);

        List<Integer> ans = new ArrayList<>(List.of(1, 2));
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 1) {
                ans.add(ans.get(ans.size() - 2) + (i - 1) + i);
            } else {
                int factorial = 1;
                for (int j = 1; j <= i; j++) {
                    factorial *= j;
                }
                ans.add(factorial);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(f(5)); // [1, 2, 6, 24, 120]
    }
}