package com.example;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

class Solution {
    public List<Integer> minPath(int[][] grid, int k) {
        int N = grid.length;
        int x = -1, y = -1;

        // 1. Find the location of 1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    break;
                }
            }
            if (x != -1) break;
        }

        // If 1 is found, proceed with finding mn
        if (x != -1) {
            int mn = N * N;
            
            // Check neighbors
            if (x > 0) {
                mn = Math.min(mn, grid[x - 1][y]);
            }
            if (x < N - 1) {
                mn = Math.min(mn, grid[x + 1][y]);
            }
            if (y > 0) {
                mn = Math.min(mn, grid[x][y - 1]);
            }
            if (y < N - 1) {
                mn = Math.min(mn, grid[x][y + 1]);
            }

            // 4. Construct the result list based on the Python logic
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (i % 2 == 0) {
                    result.add(1);
                } else {
                    result.add(mn);
                }
            }
            return result;
        }
        
        // Should not be reached if input guarantees are met
        return new ArrayList<>();
    }
}