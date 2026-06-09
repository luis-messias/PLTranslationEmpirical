package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_5 {
    
    public static void main(String[] args) {
        List<Integer> result = intersperse(new ArrayList<>(List.of(1, 2, 3)), 4);
        System.out.println(result); // [1, 4, 2, 4, 3]
        
        result = intersperse(new ArrayList<>(), 4);
        System.out.println(result); // []
    }

    public static List<Integer> intersperse(List<Integer> numbers, int delimiter) {
        List<Integer> res = new ArrayList<>();
        for (int i : numbers) {
            res.add(i);
            if (!numbers.isEmpty()) { // Check to avoid IndexOutOfBoundsException
                res.add(delimiter);
            }
        }
        return res;
    }
}