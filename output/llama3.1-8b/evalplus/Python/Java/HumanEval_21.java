package com.example;
import java.util.Arrays;
import java.util.function.Function;

public class HumanEval_21 {
    public static double[] rescaleToUnit(double[] numbers) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Input array must have at least two elements");
        }
        
        double max = Arrays.stream(numbers).max().getAsDouble();
        double min = Arrays.stream(numbers).min().getAsDouble();
        
        if (max == min) {
            return numbers;
        }
        
        Function<Double, Double> scalingFunction = x -> (x - min) / (max - min);
        return Arrays.stream(numbers)
                .map(scalingFunction)
                .toArray();
    }

    public static void main(String[] args) {
        double[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0};
        System.out.println(Arrays.toString(rescaleToUnit(numbers)));
    }
}