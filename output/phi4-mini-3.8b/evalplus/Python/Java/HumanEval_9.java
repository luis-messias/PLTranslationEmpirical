package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_9 {

    public static List<Integer> rolling_max(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                if (numbers.get(j) > maxVal)
                    maxVal = numbers.get(j);
            }
            result.add(maxVal);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>();
        // Add elements to the list
        for(int i : {1, 2, 3, 2, 3, 4, 2}.toArray()) {
            inputList.add(i);
        }
        
        System.out.println(rolling_max(inputList));
    }
}