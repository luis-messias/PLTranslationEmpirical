package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_130 {

    public static List<Double> tri(int n) {
        if (n == 0) {
            return new ArrayList<>(List.of(1.0));
        }
        if (n == 1) {
            return new ArrayList<>(List.of(1.0, 3.0));
        }

        List<Double> ans = new ArrayList<>();
        ans.add(1.0);
        ans.add(3.0);

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                ans.add((double)(1 + i / 2));
            } else {
                double sum = ans.get(i - 1)
                              + ans.get(i - 2)
                              + ((i + 1) / 2.0);
                ans.add(sum);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(tri(3)); // Example usage
    }
}