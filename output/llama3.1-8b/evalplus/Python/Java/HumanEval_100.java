package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_100 {
    public static List<Integer> makeAPile(int n) {
        List<Integer> ans = new ArrayList<>();
        int num = n;
        for (int i = 0; i < n; i++) {
            ans.add(num);
            if (num % 2 == 0) {
                num += 1;
            } else {
                num += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(makeAPile(3));
    }
}