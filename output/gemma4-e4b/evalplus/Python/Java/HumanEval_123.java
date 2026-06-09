package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    /**
     * Given a positive integer n, return a sorted list that has the odd numbers in collatz sequence.
     *
     * @param n The starting positive integer.
     * @return A sorted list of odd numbers found in the Collatz sequence.
     */
    public static List<Long> getOddCollatz(long n) {
        List<Long> ans = new ArrayList<>();
        long x = n;

        while (x != 1) {
            if (x % 2 != 0) {
                ans.add(x);
            }

            if (x % 2 == 0) {
                x = x / 2;
            } else {
                // Check for potential overflow before calculation, though standard long should suffice for typical test cases.
                // Since the Python version implies standard integer handling, we proceed with standard long arithmetic.
                x = 3 * x + 1;
            }
        }
        
        // 1 is always the last element and is odd.
        ans.add(1L);
        
        // Sort the list in increasing order
        Collections.sort(ans);
        
        return ans;
    }
}