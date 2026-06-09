package com.example;
class Solution {
    public static int maxFill(int[][] grid, int capacity) {
        int ans = 0;
        
        for (int[] row : grid) {
            int totalWater = 0;
            for (int cell : row) {
                totalWater += cell;
            }
            
            // Calculate ceil(totalWater / capacity) using integer arithmetic: (A + B - 1) / B
            int bucketsNeeded = (totalWater + capacity - 1) / capacity;
            
            ans += bucketsNeeded;
        }
        
        return ans;
    }
}