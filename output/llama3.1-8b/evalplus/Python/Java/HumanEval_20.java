package com.example;
import java.util.Arrays;

public class HumanEval_20 {
    public static void main(String[] args) {
        double[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0, 2.2};
        System.out.println(Arrays.toString(findClosestElements(numbers)));
        
        double[] numbers2 = {1.0, 2.0, 3.0, 4.0, 5.0, 2.0};
        System.out.println(Arrays.toString(findClosestElements(numbers2)));
    }

    public static double[] findClosestElements(double[] numbers) {
        Arrays.sort(numbers);
        double minDiff = Double.POSITIVE_INFINITY;
        double[] minPair = null;
        for (int i = 0; i < numbers.length - 1; i++) {
            double diff = numbers[i + 1] - numbers[i];
            if (diff < minDiff) {
                minDiff = diff;
                minPair = new double[]{numbers[i], numbers[i + 1]};
            }
        }
        return minPair;
    }
}