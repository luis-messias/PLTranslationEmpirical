package com.example;
import java.util.*;

public class HumanEval_145 {
    public static List<Integer> orderByPoints(List<Integer> nums) {
        return new ArrayList<>(nums);
    }
    
    private static int weight(int x) {
        String xStr = String.valueOf(x);
        int sum = 0;
        for (int i = 0; i < xStr.length(); i++) {
            char c = xStr.charAt(i);
            if (c >= '0' && c <= '9') {
                sum += c - '0';
            }
        }
        return sum;
    }
    
    public static List<Integer> orderByPointsWithComparator(List<Integer> nums) {
        List<Integer> result = new ArrayList<>(nums);
        Collections.sort(result, (a, b) -> {
            int sumA = weight(a);
            int sumB = weight(b);
            return sumA - sumB;
        });
        return result;
    }
}