package com.example;
class Solution {
    public int[] compare(int[] game, int[] guess) {
        if (game == null || guess == null || game.length != guess.length) {
            throw new IllegalArgumentException("Arrays must be non-null and have equal length.");
        }

        int n = game.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = Math.abs(game[i] - guess[i]);
        }

        return result;
    }
}