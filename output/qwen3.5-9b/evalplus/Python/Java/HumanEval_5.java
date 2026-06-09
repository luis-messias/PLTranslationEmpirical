package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_5 {
    /**
     * Insert a number 'delimiter' between every two consecutive elements of input list `numbers'
     * @param numbers the input list of integers
     * @param delimiter the number to insert between elements
     * @return a new list with delimiter inserted between consecutive elements
     */
    public static List<Integer> intersperse(List<Integer> numbers, int delimiter) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            res.add(numbers.get(i));
            if (i != numbers.size() - 1) {
                res.add(delimiter);
            }
        }
        return res;
    }
}