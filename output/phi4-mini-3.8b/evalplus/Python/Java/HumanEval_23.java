package com.example;
public class HumanEval_23 {

    public static int strlen(String str) {

        if (str == null) {

            throw new IllegalArgumentException("String cannot be null");

        }

        return str.length();

    }


}