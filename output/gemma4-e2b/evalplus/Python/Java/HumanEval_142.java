package com.example;
class Solution {
    public static long sumSquares(int[] lst) {
        long ans = 0;
        for (int i = 0; i < lst.length; i++) {
            int num = lst[i];
            if (i % 3 == 0) {
                ans += (long)num * num;
            } else if (i % 4 == 0) {
                ans += (long)num * num * num;
            } else {
                ans += num;
            }
        }
        return ans;
    }
}