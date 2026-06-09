package com.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HumanEval_26 {

    public static List<Integer> removeDuplicates(List<Integer> numbers) {
        HashMap<Integer, Integer> numCnt = new HashMap<>();
        
        for (Integer number : numbers) {
            if (!numCnt.containsKey(number)) {
                numCnt.put(number, 0);
            }
            numCnt.put(number, numCnt.get(number) + 1);
        }

        List<Integer> resultList = new ArrayList<>();

        for (Integer number : numbers) {
            if (numCnt.get(number) == 1) {
                resultList.add(number);
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        // Test the method with an example
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(2);
        input.add(4);

        System.out.println(removeDuplicates(input));  // Output: [1, 3, 4]
    }
}