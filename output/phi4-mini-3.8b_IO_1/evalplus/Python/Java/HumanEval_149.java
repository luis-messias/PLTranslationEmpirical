package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HumanEval_149 {

    public static ArrayList<String> listSort(ArrayList<String> input) {
        Collections.sort(input, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return Integer.compare(s1.length(), s2.length());
                }

                for (int i = 0; i < Math.min(s1.length(), s2.length()); ++i) {
                    char c1 = Character.toLowerCase(s1.charAt(i));
                    char c2 = Character.toLowerCase(s2.charAt(i));

                    if (c1 != c2) {
                        return Integer.compare(c1, c2);
                    }
                }

                return 0;
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
