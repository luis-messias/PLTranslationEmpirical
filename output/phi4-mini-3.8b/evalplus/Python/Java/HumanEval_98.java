package com.example;
public class HumanEval_98 {

    public static int countUpper(String s) {

        int cnt = 0;

        for (int i = 0; i < s.length(); i += 2) {

            char c = Character.toUpperCase(s.charAt(i));

            if ("AEIOU".indexOf(c) != -1) {

                cnt++;

            }

        }

        return cnt;

    }


    public static void main(String[] args) {

        System.out.println(countUpper("aBCdEf")); // Output: 1

        System.out.println(countUpper("abcdefg")); // Output: 0

        System.out.println(countUpper("dBBE"));   // Output: 0

    }

}