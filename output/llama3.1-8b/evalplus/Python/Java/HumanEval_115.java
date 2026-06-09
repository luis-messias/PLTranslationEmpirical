package com.example;
public class HumanEval_115 {
    public static int maxFill(int[][] grid, int capacity) {
        int ans = 0;
        for (int[] l : grid) {
            ans += (int) Math.ceil((double) java.util.Arrays.stream(l).sum() / capacity);
        }
        return ans;
    }

    public static void main(String[] args) {
        // Test cases
        int[][] grid1 = {{0, 0, 1, 0}, {0, 1, 0, 0}, {1, 1, 1, 1}};
        System.out.println(maxFill(grid1, 1)); // Output: 6

        int[][] grid2 = {{0, 0, 1, 1}, {0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(maxFill(grid2, 2)); // Output: 5

        int[][] grid3 = {{0, 0, 0}, {0, 0, 0}};
        System.out.println(maxFill(grid3, 5)); // Output: 0
    }
}