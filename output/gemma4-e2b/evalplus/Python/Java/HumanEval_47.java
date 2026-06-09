package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_47 {
    public static double median(List<Double> l) {
        List<Double> sortedL = new ArrayList<>(l);
        Collections.sort(sortedL);
        int n = sortedL.size();

        if (n % 2 == 1) {
            // Odd length: return the middle element
            return sortedL.get(n / 2);
        } else {
            // Even length: return the average of the two middle elements
            double middle1 = sortedL.get(n / 2 - 1);
            double middle2 = sortedL.get(n / 2);
            return (middle1 + middle2) / 2.0;
        }
    }
}