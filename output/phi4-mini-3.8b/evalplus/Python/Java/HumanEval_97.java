package com.example;
public class HumanEval_97 {
    
    public static void main(String[] args) {
        System.out.println(multiply(148, 412)); // should print 16
        System.out.println(multiply(19, 28));   // should print 72
        System.out.println(multiply(2020, 1851));// should print 0
        System.out.println(multiply(14,-15));// should print 20
    }

    public static int multiply(int a, int b) {
        return Character.getNumericValue(String.valueOf(a).charAt(String.valueOf(a)).toString()) * 
               Character.getNumericValue(String.valueOf(b).charAt(String.valueOf(b)).toString());
    }
}