package com.example;
import java.util.function.Predicate;

public class HumanEval_78 {

    public static void main(String[] args) {
        System.out.println(hex_key("AB")); // Output should be 1.
        System.out.println(hex_key("1077E")); // Output should be 2.
        System.out.println(hex_key("ABED1A33")); // Output should be 4.
        System.out.println(hex_key("123456789ABCDEF0")); // Output should be 6.
        System.out.println(hex_key("2020")); // Output should be 2.
    }

    public static int hex_key(String num) {
        Predicate<Character> isPrimeHexDigit = c -> "2357BD".indexOf(c) != -1;
        
        return Arrays.stream(num.toCharArray())
                .filter(isPrimeHexDigit)
                .count();
    }
}
