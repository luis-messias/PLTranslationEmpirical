package com.example;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

class Solution {
    /**
     * Translates the provided Python logic for minPath.
     * Note: This implementation translates the provided Python code exactly, 
     * regardless of whether the original logic solves the complex problem described in the docstring.
     * 
     * @param grid The grid of values.
     * @param k The desired path length.
     * @return A list of integers representing the calculated path.
     */
    public List<Integer> minPath(int[][] grid, int k) {
        int N = grid.length;
        int x = 0;
        int y = 0;

        // 1. Find coordinates (x, y) where grid[x][y] == 1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    // Assuming 1 appears exactly once, we can break early
                    break; 
                }
            }
            if (x != i && y != j && grid[i][j] == 1) {
                // This check is complex due to nested loops, but since we found it, we can rely on the break above
                // For simplicity and correctness based on the Python structure, we just let the loops run or break fully.
            }
        }

        // 2. Calculate mn (minimum neighbor value)
        int mn = N * N;

        // Check neighbors: Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            // Check bounds
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                mn = Math.min(mn, grid[nx][ny]);
            }
        }

        // 3. Build the result list: alternates between 1 and mn
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
}
