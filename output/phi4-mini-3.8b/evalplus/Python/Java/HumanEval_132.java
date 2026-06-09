package com.example;
public class HumanEval_132 {

    public static boolean isNested(String string) {

        for (int i = 0; i < string.length(); i++) {
            if ("]".equals(string.charAt(i))) continue;

            int cnt, maxNest = 0;
            for (int j = i; j < string.length(); j++) {
                char ch = string.charAt(j);

                if ("["