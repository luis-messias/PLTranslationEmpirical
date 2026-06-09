package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_62 {
    public static List<Integer> derivative(List<Integer> xs) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < xs.size(); i++) {
            result.add(xs.get(i) * i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(derivative(List.of(3, 1, 2, 4, 5)));
        System.out.println(derivative(List.of(1, 2, 3)));
    }
}