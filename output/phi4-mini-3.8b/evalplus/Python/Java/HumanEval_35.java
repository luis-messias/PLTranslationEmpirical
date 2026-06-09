package com.example;
public class HumanEval_35 {

    public static double max_element(double[] arr) {

        if (arr == null || arr.length == 0) {

            throw new IllegalArgumentException("Array is empty or null");

        }

        assert allElementsAreNumeric(arr): "Invalid inputs";

        return Arrays.stream(arr).max().orElse(Double.NEGATIVE_INFINITY);

    }


    private static boolean allElementsAreNumeric(double[] array) {

        for (double element : array) {

            if (!Double.isFinite(element)) {

                return false;

            }

        }

        return true;

    }


}