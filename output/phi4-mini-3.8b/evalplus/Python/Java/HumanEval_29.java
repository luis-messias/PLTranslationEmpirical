package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_29 {

    public static List<String> filterByPrefix(List<String> strings, String prefix) {
        List<String> result = new ArrayList<>();
        for (String str : strings) {
            if (str.startsWith(prefix)) {
                result.add(str);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(filterByPrefix(new ArrayList<>(), "a"));  // []
        List<String> testStrings = new ArrayList<>();
        testStrings.add("abc");
        testStrings.add("bcd");
        testStrings.add("cde");
        testStrings.add("array");
        System.out.println(filterByPrefix(testStrings, "a"));  // [abc, array]
    }
}