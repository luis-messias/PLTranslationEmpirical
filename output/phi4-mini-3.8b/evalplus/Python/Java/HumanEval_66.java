package com.example;
public class HumanEval_66 {
    
    public static int digitSum(String s) {
        // Task: Write a function that takes a string as input and returns the sum of the upper characters only' ASCII codes.
        
        return (s == null || s.isEmpty()) ? 0 : 
               s.chars().filter(ch -> Character.isUpperCase((char) ch)).map(Character::getNumericValue).sum();
    }

    public static void main(String[] args) {
        System.out.println(digitSum(""));
        System.out.println(digitSum("abAB"));
        System.out.println(digitSum("abcCd"));
        System.out.println(digitSum("helloE"));
        System.out.println(digitSum("woArBld"));
        System.out.println(digitSum("aAaaaXa"));
    }
}