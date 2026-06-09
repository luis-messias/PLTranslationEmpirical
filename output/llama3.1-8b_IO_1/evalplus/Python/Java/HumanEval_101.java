package com.example;

import java.util.ArrayList;
import java.util.List;

public class HumanEval_101 {
    public static List<String> wordsString(String s) {
        String[] words = s.replace(",", " ").split("\\s+");
        return new ArrayList<>(List.of(words));
    }

    public static void main(String[] args) {
        System.out.println(wordsString("Hi, my name is John"));
        System.out.println(wordsString("One, two, three, four, five, six"));
    }
}
