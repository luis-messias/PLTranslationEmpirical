package com.example;
public class HumanEval_161 {
    public static String solve(String s) {
        StringBuilder ans = new StringBuilder();
        boolean hasLetter = false;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
                ans.append(Character.toString(c).toLowerCase().equals(Character.toString(c)) ? Character.toUpperCase(c) : Character.toLowerCase(c));
            } else {
                ans.append(c);
            }
        }
        return hasLetter ? ans.toString() : new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("1234"));
        System.out.println(solve("ab"));
        System.out.println(solve("#a@C"));
    }
}