package com.example;
public class HumanEval_89 {
    public static String encrypt(String s) {
        String d = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (d.indexOf(ch) != -1) {
                int shifted = (ch - 'a' + 4) % 26 + 'a';
                result.append((char) shifted);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}