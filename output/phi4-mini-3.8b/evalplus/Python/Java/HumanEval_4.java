package com.example;
import java.util.List;

public class HumanEval_4 {

    public static double meanAbsoluteDeviation(List<Double> numbers) {

        double mean = calculateMean(numbers);

        double madSum = 0.0;

        for (double number : numbers) {

            madSum += Math.abs(number - mean);
        }

        return madSum / numbers.size();

    }


    private static double calculateMean(List<Double> numbers) {

        if (numbers.isEmpty()) {

            throw new IllegalArgumentException("List cannot be empty");

        }

        double sum = 0.0;

        for (double number : numbers) {

            sum += number;
        }

        return sum / numbers.size();

    }


}