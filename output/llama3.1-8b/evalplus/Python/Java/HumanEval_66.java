package com.example;
public class HumanEval_66 {
    public static int digitSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sum += c;
            }
        }
        return sum;
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