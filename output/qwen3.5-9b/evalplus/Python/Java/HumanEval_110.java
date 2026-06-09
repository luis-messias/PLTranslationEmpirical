package com.example;
import java.util.List;

public class HumanEval_110 {
    public static String exchange(List<Integer> lst1, List<Integer> lst2) {
        int cntOdd = (int) lst1.stream()
            .filter(x -> x % 2 == 1)
            .count();
        
        int cntEven = (int) lst2.stream()
            .filter(x -> x % 2 == 0)
            .count();
        
        return cntOdd <= cntEven ? "YES" : "NO";
    }
}