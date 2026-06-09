package com.example;
public class HumanEval_97 {
    public static int multiply(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);
        return (int)strA.charAt(strA.length() - 1) * (int)strB.charAt(strB.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(multiply(148, 412)); // prints: 16
        System.out.println(multiply(19, 28));   // prints: 72
        System.out.println(multiply(2020, 1851)); // prints: 0
        System.out.println(multiply(14,-15));    // prints: 20
    }
}