package com.example;
import java.util.HashSet;

public class HumanEval_16 {

    public static int countDistinctCharacters(String string) {
        HashSet<Character> distinctChars = new HashSet<>();

        for (char ch : string.toLowerCase().toCharArray()) {
            if (!distinctChars.contains(ch)) {
                distinctChars.add(ch);
            }
        }

        return distinctChars.size();
    }

    public static void main(String[] args) {

        System.out.println(countDistinctCharacters("xyzXYZ")); // Output: 3

        System.out.println(countDistinctCharacters("Jerry"));   // Output: 4
    }
}
