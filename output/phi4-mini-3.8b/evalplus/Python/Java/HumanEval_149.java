package com.example;
import java.util.ArrayList;

import java.util.Collections;


public class HumanEval_149 {

    public static ArrayList<String> listSort(ArrayList<String> input) {

        Collections.sort(input, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {

                if (s1.length() != s2.length()) {
                    return Integer.compare(s1.length(), s2.length());

                }

                char[] arr = { 'a', 'b' };

                for (int i = 0; i < Math.min(arr.length, s1.length()); ++i) {

                    int comparisonResult = Character.compare(s1.charAt(i), s2.charAt(i));

                    if (comparisonResult != 0) {
                        return Integer.compare(comparisonResult, arr[i]);

                    }

                }

                return -1;

            }
        });

        ArrayList<String> result = new ArrayList<>();

        for (String str : input) {

            if (str.length() % 2 == 0) {

                result.add(str);

            }

        }

        Collections.sort(result, Comparator.comparingInt(String::length));

        return result;

    }


}