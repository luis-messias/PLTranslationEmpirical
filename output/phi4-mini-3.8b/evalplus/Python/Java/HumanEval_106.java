package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_106 {

    public static void main(String[] args) {
        int n = 5; // Example usage, can be changed as needed.
        List<Integer> result = f(n);
        
        System.out.println(result); // Output the list
    }

    public static List<Integer> f(int n) {
        if (n == 0) return new ArrayList<>();
        if (n == 1) return new ArrayList<>(Collections.singletonList(1));
        if (n == 2) return new ArrayList<>(Arrays.asList(1, 2));

        List<Integer> ans = new ArrayList<>(Lists.newArrayList(new Integer[]{1, 2}));
        
        for (int i = 3; i <= n; i++) {
            int prevFactorialSum;
            if (i % 2 == 0) { // Even index
                prevFactorialSum = ((ans.get(i - 2)) * (i - 1));
            } else { // Odd index
                prevFactorialSum = ans.get(i - 2);
            }
            
            int nextValue;
            if (i % 2 == 0) {
                nextValue = prevFactorialSum + i; 
            } else {
                nextValue = prevFactorialSum * i;
            }

            ans.add(nextValue); // Add the calculated value to list
        }
        
        return ans;
    }
}