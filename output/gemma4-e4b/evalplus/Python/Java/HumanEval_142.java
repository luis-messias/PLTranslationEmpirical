package com.example;
class Solution {
    public long sumSquares(int[] lst) {
        long ans = 0;
        for (int i = 0; i < lst.length; i++) {
            int num = lst[i];
            if (i % 3 == 0) {
                // Square the number
                ans += (long)num * num;
            } else if (i % 4 == 0) {
                // Cube the number
                ans += (long)num * num * num;
            } else {
                // Keep the original number
                ans += num;
            }
        }
        return ans;
    }
}