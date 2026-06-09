package com.example;
public class HumanEval_98 {
    public static int countUpper(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if ("AEIOU".indexOf(s.charAt(i)) != -1) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countUpper("aBCdEf")); // returns 1
        System.out.println(countUpper("abcdefg")); // returns 0
        System.out.println(countUpper("dBBE")); // returns 0
    }
}