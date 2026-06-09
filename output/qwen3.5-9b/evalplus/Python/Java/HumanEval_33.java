package com.example;
import java.util.*;

public class HumanEval_33 {
    public static List<Integer> sortThird(List<Integer> l) {
        List<Integer> third = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if (i % 3 == 0) {
                third.add(l.get(i));
            }
        }
        Collections.sort(third);
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if (i % 3 == 0) {
                result.add(third.get(i / 3));
            } else {
                result.add(l.get(i));
            }
        }
        return result;
    }
}