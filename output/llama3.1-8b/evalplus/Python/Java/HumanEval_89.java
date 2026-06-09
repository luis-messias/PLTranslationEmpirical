package com.example;
public class HumanEval_89 {
    public static String encrypt(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.append((char) ((c - 'a' + 4) % 26 + 'a'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("hi")); // lm
        System.out.println(encrypt("asdfghjkl")); // ewhjklnop
        System.out.println(encrypt("gf")); // kj
        System.out.println(encrypt("et")); // ix
    }
}