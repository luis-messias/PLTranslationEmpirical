package com.example;
class Solution {
    public boolean willItFly(int[] q, int w) {
        // Check if q is balanced (palindromic)
        boolean isBalanced = true;
        int n = q.length;
        for (int i = 0; i < n / 2; i++) {
            if (q[i] != q[n - 1 - i]) {
                isBalanced = false;
                break;
            }
        }

        if (!isBalanced) {
            return false;
        }

        // Check if the sum of elements is less than or equal to w
        long sum = 0;
        for (int x : q) {
            sum += x;
        }

        return sum <= w;
    }
}