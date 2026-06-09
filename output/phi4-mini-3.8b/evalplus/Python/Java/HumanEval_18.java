package com.example;
public class HumanEval_18 {

    public static int howManyTimes(String str, String subStr) {

        int occurrences = 0;

        for (int i = 0; i <= str.length() - subStr.length(); ) {

            if (str.substring(i).equals(subStr)) {

                occurrences++;

                i += subStr.length();

            } else {

                i++;
            }

        }

        return occurrences;

    }


    public static void main(String[] args) {

        System.out.println(howManyTimes("", "a")); // 0

        System.out.println(howManyTimes("aaa", "a")); // 3

        System.out.println(howManyTimes("aaaa", "aa")); // 3

    }

}