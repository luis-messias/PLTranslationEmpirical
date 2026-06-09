package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_30 {
    
    public static List<Integer> getPositive(List<Integer> numbers) {
        List<Integer> positiveNumbers = new ArrayList<>();
        
        for (Integer number : numbers) {
            if (number > 0) {
                positiveNumbers.add(number);
            }
        }

        return positiveNumbers;
    }

    public static void main(String[] args) {
        System.out.println(getPositive(Arrays.asList(-1, 2, -4, 5, 6))); // [2, 5, 6]
        System.out.println(getPositive(Arrays.asList(5, 3, -5, 2, -3, 3, 9, 0, 123, 1, -10))); // [5, 3, 2, 3, 9, 123, 1]
    }
}