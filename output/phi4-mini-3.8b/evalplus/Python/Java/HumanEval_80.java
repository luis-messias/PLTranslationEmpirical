package com.example;
public class HumanEval_80 {

    public static boolean isHappy(String s) {

        if (s.length() < 3) return false;

        for (int i = 0; i <= s.length() - 3; i++) {

            char c1 = s.charAt(i);

            char c2 = s.charAt(i + 1);

            char c3 = s.charAt(i + 2);


            if (c1 == c2 || c1 == c3 || c2 == c3) return false;

        }

        return true;

    }


}