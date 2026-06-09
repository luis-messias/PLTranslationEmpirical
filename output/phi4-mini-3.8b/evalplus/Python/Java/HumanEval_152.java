package com.example;
import java.util.Arrays;

public class HumanEval_152 {

    public static int[] compare(int[] game, int[] guess) {
        if (game.length != guess.length) {
            throw new IllegalArgumentException("Arrays must be of equal length");
        }

        return Arrays.stream(game)
                     .map(i -> Math.abs(i - guess[i]))
                     .toArray();
    }
    
    public static void main(String[] args) {
        int[] result1 = compare(new int[]{1, 2, 3, 4, 5, 1}, new int[]{1, 2, 3, 4, 2, -2});
        System.out.println(Arrays.toString(result1)); // Output: [0, 0, 0, 0, 3, 3]

        int[] result2 = compare(new int[]{0, 5, 0, 0, 0, 4}, new int[]{4, 1, 1, 0, 0, -2});
        System.out.println(Arrays.toString(result2)); // Output: [4, 4, 1, 0, 0, 6]
    }
}