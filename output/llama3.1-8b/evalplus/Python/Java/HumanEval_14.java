package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_14 {
    public static List<String> allPrefixes(String string) {
        List<String> prefixes = new ArrayList<>();
        for (int i = 0; i <= string.length(); i++) {
            prefixes.add(string.substring(0, i));
        }
        return prefixes;
    }

    public static void main(String[] args) {
        System.out.println(allPrefixes("abc"));
    }
}