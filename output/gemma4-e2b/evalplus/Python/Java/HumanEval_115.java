package com.example;
class Solution {
    public int maxFill(int[][] grid, int capacity) {
        int ans = 0;
        for (int[] row : grid) {
            int sum = 0;
            for (int cell : row) {
                sum += cell;
            }
            ans += (int) Math.ceil((double) sum / capacity);
        }
        return ans;
    }
}