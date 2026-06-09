package com.example;
import java.util.List;

public class HumanEval_110 {

    public static String exchange(List<Integer> lst1, List<Integer> lst2) {
        long countOdd = (long)lst1.stream().filter(x -> x % 2 == 1).count();
        long countEven = (long)lst2.stream().filter(x -> x % 2 == 0).count();

        return (countOdd <= countEven / 2L) ? "YES" : "NO";
    }

}
