package com.example;
import java.util.*;

public class HumanEval_129 {
    public static List<Integer> minPath(int[][] grid, int k) {
        int N = grid.length;
        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        int mn = N * N;
        if (x > 0) mn = Math.min(mn, grid[x - 1][y]);
        if (x < N - 1) mn = Math.min(mn, grid[x + 1][y]);
        if (y > 0) mn = Math.min(mn, grid[x][y - 1]);
        if (y < N - 1) mn = Math.min(mn, grid[x][y + 1]);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(i % 2 == 0 ? 1 : mn);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minPath(grid, 3));
        
        grid = new int[][]{{5, 9, 3}, {4, 1, 6}, {7, 8, 2}};
        System.out.println(minPath(grid, 1));
    }
}