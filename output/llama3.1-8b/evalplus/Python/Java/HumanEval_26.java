package com.example;
import java.util.*;

public class HumanEval_26 {
    public static List<Integer> removeDuplicates(List<Integer> numbers) {
        Map<Integer, Integer> numCnt = new HashMap<>();
        for (Integer number : numbers) {
            if (!numCnt.containsKey(number)) {
                numCnt.put(number, 0);
            }
            numCnt.put(number, numCnt.get(number) + 1);
        }
        return numbers.stream()
                .filter(num -> numCnt.get(num) == 1)
                .toList();
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4);
        System.out.println(removeDuplicates(numbers));
    }
}