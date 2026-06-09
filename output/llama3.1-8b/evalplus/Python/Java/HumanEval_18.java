package com.example;
public class HumanEval_18 {
    public static int howManyTimes(String string, String substring) {
        int occurences = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.startsWith(substring, i)) {
                occurences++;
            }
        }
        return occurences;
    }

    public static void main(String[] args) {
        System.out.println(howManyTimes("", "a")); // 0
        System.out.println(howManyTimes("aaa", "a")); // 3
        System.out.println(howManyTimes("aaaa", "aa")); // 3
    }
}