package com.example;

import java.util.*;

public class HumanEval_104 {
    public static List<Integer> uniqueDigits(List<Integer> x) {
        return new ArrayList<>(new HashSet<>(x).stream()
                .filter(num -> hasNoEvenDigit(num))
                .sorted());
    }

    private static boolean hasNoEvenDigit(int num) {
        String strNum = Integer.toString(num);
        for (char c : strNum.toCharArray()) {
            if ((c - '0') % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
