package com.example;
import java.util.*;

public class HumanEval_16 {
    public static int countDistinctCharacters(String string) {
        Set<Character> distinctChars = new HashSet<>();
        for (char c : string.toLowerCase().toCharArray()) {
            distinctChars.add(c);
        }
        return distinctChars.size();
    }

    public static void main(String[] args) {
        System.out.println(countDistinctCharacters("xyzXYZ"));  // prints: 3
        System.out.println(countDistinctCharacters("Jerry"));   // prints: 4
    }
}