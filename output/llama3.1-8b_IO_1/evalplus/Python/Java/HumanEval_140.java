package com.example;

public class HumanEval_140 {
    public static String fixSpaces(String text) {
        StringBuilder ans = new StringBuilder(text);
        for (int i = 2; i <= text.length(); i++) {
            ans = ans.replace(" ".repeat(i), "-" + " ".repeat(i));
        }
        return ans.toString().replace(' ', '_');
    }

    public static void main(String[] args) {
        System.out.println(fixSpaces("Example")); // Example
        System.out.println(fixSpaces("Example 1")); // Example_1
        System.out.println(fixSpaces(" Example 2")); // _Example_2
        System.out.println(fixSpaces(" Example   3")); // _Example-3
    }
}
