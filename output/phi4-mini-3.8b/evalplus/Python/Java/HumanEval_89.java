package com.example;
public class HumanEval_89 {

    public static String encrypt(String s) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        return new StringBuilder().append(s)
                .replaceAll("[^a-zA-Z]", "") // Remove non-alphabet characters.
                .chars()
                .map(ch -> Character.isLowerCase(ch) ? 
                        (char)(ch + 4 - 'a') % 26 + 'a' : ch)
                .toArray()
                .toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("hi")); // Output: lm
        System.out.println(encrypt("asdfghjkl")); // Output: ewhjklnop
        System.out.println(encrypt("gf")); // Output: kj
        System.out.println(encrypt("et")); // Output: ix
    }
}