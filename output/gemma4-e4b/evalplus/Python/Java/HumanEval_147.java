package com.example;
class Solution {
    public static long get_max_triples(int n) {
        if (n <= 2) {
            return 0;
        }

        // Calculate one_cnt based on the provided formula
        // Python: one_cnt = 1 + (n - 2) // 3 * 2 + (n - 2) % 3