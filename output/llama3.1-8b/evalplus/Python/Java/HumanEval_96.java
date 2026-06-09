package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_96 {
    public static List<Integer> countUpTo(int n) {
        if (n < 2) {
            return new ArrayList<>();
        }
        
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                ans.add(i);
                for (int j = i + i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countUpTo(5)); // [2, 3]
        System.out.println(countUpTo(11)); // [2, 3, 5, 7]
        System.out.println(countUpTo(0)); // []
        System.out.println(countUpTo(20)); // [2, 3, 5, 7, 11, 13, 17, 19]
        System.out.println(countUpTo(1)); // []
        System.out.println(countUpTo(18)); // [2, 3, 5, 7, 11, 13, 17]
    }
}