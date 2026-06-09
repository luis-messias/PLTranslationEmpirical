package com.example;
import java.util.List;
import java.lang.Math;

public class HumanEval_133 {
    public static double sumSquares(List<Double> lst) {
        double sum = 0.0;
        for (double x : lst) {
            double ceiled = Math.ceil(x);
            sum += ceiled * ceiled;
        }
        return sum;
    }
}