package com.example;
class Solution {
    public static long get_max_triples(int n) {
        if (n <= 2) {
            return 0;
        }

        // Python: one_cnt = 1 + (n - 2) // 3 * 2 + (n - 2) % 3
        // Use long for calculations involving counts to prevent potential overflow.
        long n_minus_2 = n - 2;
        long one_cnt = 1 + (n_minus_2 / 3) * 2 + (n_minus_2 % 3);
        
        long zero_cnt = n - one_cnt;

        // Calculate C(k, 3) = k * (k - 1) * (k - 2) / 6
        
        // C(one_cnt, 3)
        long term1 = one_cnt * (one_cnt - 1) * (one_cnt - 2) / 6;
        
        // C(zero_cnt, 3)
        long term2 = zero_cnt * (zero_cnt - 1) * (zero_cnt - 2) / 6;
        
        return term1 + term2;
    }
}
