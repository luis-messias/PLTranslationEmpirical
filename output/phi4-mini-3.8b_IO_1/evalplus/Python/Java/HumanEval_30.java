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

}
