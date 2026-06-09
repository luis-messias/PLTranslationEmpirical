package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_129 {

    public static List<Integer> minPath(int[][] grid, int k) {
        int N = grid.length;
        int x = 0, y = 0;
        
        // Find the position of '1' in the grid
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        int mn = Integer.MAX_VALUE;

        // Check the neighbors of '1'
        if (x > 0) mn = Math.min(mn, grid[x - 1][y]);
        if (x < N - 1) mn = Math.min(mn, grid[x + 1][y]);
        if (y > 0) mn = Math.min(mn, grid[x][y - 1]);
        if (y < N - 1) mn = Math.min(mn, grid[x][y + 1]);

        List<Integer> result = new ArrayList<>();
        
        // Construct the path
        for (int i = 0; i < k; i++) {
            int value;
            if ((i % 2 == 0)) {
                value = 1;
            } else {
                value = mn;
            }
            result.add(value);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        int[][] grid1 = { {5,9,3}, {4,1,6}, {7,8,2} };
        System.out.println(minPath(grid1, 1)); // Output: [1]

        int[][] grid2 = { {1,2,3}, {4,5,6}, {7,8,9} };
        List<Integer> result = minPath(grid2, 3);
        for (int i : result) {
            System.out.print(i + " ");
        }
        // Output: [1 2 1]
    }
}