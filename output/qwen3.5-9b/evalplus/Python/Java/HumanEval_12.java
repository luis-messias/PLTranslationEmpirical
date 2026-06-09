package com.example;
import java.util.List;

public class HumanEval_12 {
    public static String longest(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return null;
        }

        int maxlen = 0;
        for (String s : strings) {
            if (s.length() > maxlen) {
                maxlen = s.length();
            }
        }

        for (String s : strings) {
            if (s.length() == maxlen) {
                return s;
            }
        }
        
        return null;
    }
}