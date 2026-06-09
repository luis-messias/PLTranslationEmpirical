package com.example;
public class HumanEval_78 {
    public static int hexKey(String num) {
        String primeDigits = "2357BD";
        return (num.length() == 0) ? 0 : num.chars().filter(c -> primeDigits.indexOf((char)c) != -1).count();
    }

    public static void main(String[] args) {
        System.out.println(hexKey("AB")); // 1
        System.out.println(hexKey("1077E")); // 2
        System.out.println(hexKey("ABED1A33")); // 4
        System.out.println(hexKey("123456789ABCDEF0")); // 6
        System.out.println(hexKey("2020")); // 2
    }
}