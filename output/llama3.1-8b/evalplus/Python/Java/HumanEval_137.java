package com.example;
public class HumanEval_137 {
    public static Object compareOne(Object a, Object b) {
        double numA = Double.parseDouble(a.toString().replace(",", "."));
        double numB = Double.parseDouble(b.toString().replace(",", "."));
        if (numA == numB) {
            return null;
        }
        return a instanceof String ? a : (a instanceof Integer || a instanceof Float) ? a : b;
    }

    public static void main(String[] args) {
        System.out.println(compareOne(1, 2.5)); // ➞ 2.5
        System.out.println(compareOne(1, "2,3")); // ➞ "2,3"
        System.out.println(compareOne("5,1", "6")); // ➞ "6"
        System.out.println(compareOne("1", 1)); // ➞ null
    }
}