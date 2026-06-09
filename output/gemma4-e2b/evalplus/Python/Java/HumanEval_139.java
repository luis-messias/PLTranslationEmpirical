package com.example;
class Solution {
    public long specialFactorial(int n) {
        if (n <= 1) {
            return 1; // Special factorial is usually defined for n > 0. For n=1, 1! = 1.
        }

        long fac = 1; // Stores the current factorial (i!)
        long ans = 1; // Stores the final result

        // The loop calculates the product of factorials: n! * (n-1)! * ... * 2!
        // The Python loop iterates i from 2 to n (inclusive)
        for (int i = 2; i <= n; i++) {
            // Update fac to be i! based on the previous value (which was (i-1)!)
            fac *= i;
            // Update ans by multiplying with the newly calculated factorial (i!)
            ans *= fac;
        }
        return ans;
    }
}