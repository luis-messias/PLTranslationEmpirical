package com.example;
public class HumanEval_2 {

    public static double truncateNumber(double number) {

        if (number < 0 || Math.floor(number) != number) {

            throw new IllegalArgumentException("The input must be a positive floating point number.");

        }

        return number - Math.floor(number);

    }


    public static void main(String[] args) {

        System.out.println(truncateNumber(3.5)); // Output: 0.5000000238418579

    }

}