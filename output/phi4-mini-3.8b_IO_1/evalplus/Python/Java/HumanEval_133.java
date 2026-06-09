package com.example;

import java.util.Arrays;
import java.lang.Math;

public class HumanEval_133 {

    public static void main(String[] args) {
        int[][] testCases = { 

            new int[]{1, 2, 3},

            new int[]{1, 4, 9},

            new int[]{1, 3, 5, 7},

            double[] testCaseFour = {1.4f, 4.2f, 0}, // Note: Java uses 'double' for floating-point numbers

            new int[]{-2, -1, 1} 

        };

        System.out.println(Arrays.stream(testCases[3]).map(Math::ceil).mapToDouble(x -> x * x).sum());
    }

}
