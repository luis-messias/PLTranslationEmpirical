package com.example;
import java.util.List;

public class HumanEval_110 {
    public static String exchange(List<Integer> lst1, List<Integer> lst2) {
        // Calculate the count of odd numbers in lst1 (the demand for even numbers)
        long cnt_odd = lst1.stream()
                               .filter(x -> x % 2 != 0)
                               .count();

        // Calculate the count of even numbers in lst2 (the supply of even numbers)
        long cnt_even = lst2.stream()
                               .filter(x -> x % 2 == 0)
                               .count();

        // Check if the supply of even numbers in lst2 is sufficient to cover the demand in lst1
        if (cnt_odd <= cnt_even) {
            return "YES";
        } else {
            return "NO";
        }
    }
}