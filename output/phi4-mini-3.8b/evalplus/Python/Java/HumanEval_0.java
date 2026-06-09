package com.example;
import java.util.Arrays;


public class HumanEval_0 {

    public static boolean hasCloseElements(double[] numbers, double threshold) {

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 1; i++) {

            if ((numbers[i + 1] - numbers[i]) < threshold) {

                return true;

            }

        }

        return false;

    }


    public static void main(String[] args) {

        System.out.println(hasCloseElements(new double[]{1.0, 2.8, 3.0, 4.0, 5.0, 2.0}, 0.3));

        // Add more test cases as needed

    }

}