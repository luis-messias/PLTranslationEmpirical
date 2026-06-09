package com.example;
import java.util.function.IntUnaryOperator;

public class HumanEval_11 {
    public static String stringXor(String a, String b) {
        return String.join("", IntStream.range(0, Math.min(a.length(), b.length()))
                .map(i -> (a.charAt(i) - '0') ^ (b.charAt(i) - '0')).mapToObj(x -> x % 2 == 1 ? "1" : "0"));
    }

    public static void main(String[] args) {
        System.out.println(stringXor("010", "110")); // prints: 100
    }
}