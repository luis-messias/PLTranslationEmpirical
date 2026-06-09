package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_7 {

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        List<String> result = new ArrayList<>();
        for (String s : strings) {
            if (s.contains(substring)) {
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(filterBySubstring(new ArrayList<>(), "a"));  // []
        List<String> testStrings = new ArrayList<>();
        testStrings.add("abc");
        testStrings.add("bacd");
        testStrings.add("cde");
        testStrings.add("array");
        System.out.println(filterBySubstring(testStrings, "a"));  // [abc, bacd, array]
    }
}