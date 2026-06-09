package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_110 {

    public static String exchange(List<Integer> lst1, List<Integer> lst2) {
        int countOdd = lst1.stream().filter(x -> x % 2 == 1).count();
        int countEven = lst2.stream().filter(x -> x % 2 == 0).count();

        return (countOdd <= countEven) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        // Example usage:
        List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of(1, 5, 3, 4);

        System.out.println(exchange(list1, list2)); // Output: NO
    }
}