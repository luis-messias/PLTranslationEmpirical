package com.example;
import java.util.List;
import java.util.ArrayList;

public class HumanEval_21 {

    public static List<Double> rescaleToUnit(List<Double> numbers) {
        if (numbers == null || numbers.size() < 2) {
            throw new IllegalArgumentException("The list must contain at least two elements.");
        }

        double ma = Double.MAX_VALUE;
        double mi = -Double.MAX_VALUE;

        for (double num : numbers) {
            ma = Math.min(ma, num);
            mi = Math.max(mi, num);
        }

        if (ma == mi) return new ArrayList<>(); // Avoid division by zero

        final double k = 1 / (ma - mi);

        List<Double> rescaledNumbers = new ArrayList<>();
        for (double number : numbers) {
            rescaledNumbers.add((number - mi) * k);
        }

        return rescaledNumbers;
    }
}