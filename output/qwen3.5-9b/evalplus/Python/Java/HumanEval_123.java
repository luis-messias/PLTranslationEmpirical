package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_123 {
    public static List<Integer> getOddCollatz(int n) {
        // Given a positive integer n, return a sorted list that has the odd numbers in collatz sequence.
        // The Collatz conjecture is a conjecture in mathematics that concerns a sequence defined
        // as follows: start with any positive integer n. Then each term is obtained from the 
        // previous term as follows: if the previous term is even, the next term is one half of 
        // the previous term. If the previous term is odd, the next term is 3 times the previous
        // term plus 1. The conjecture is that no matter what value of n, the sequence will always reach 1.
        // Note: 
        //     1. Collatz(1) is [1].
        //     2. returned list sorted in increasing order.
        // For example:
        // getOddCollatz(5) returns [1, 5] # The collatz sequence for 5 is [5, 16, 8, 4, 2, 1], so the odd numbers are only 1, and 5.
        
        List<Integer> ans = new ArrayList<>();
        int x = n;
        while (x != 1) {
            if (x % 2 == 1) {
                ans.add(x);
            }
            x = (x % 2 == 0) ? x / 2 : x * 3 + 1;
        }
        ans.add(1);
        Collections.sort(ans);
        return ans;
    }
}