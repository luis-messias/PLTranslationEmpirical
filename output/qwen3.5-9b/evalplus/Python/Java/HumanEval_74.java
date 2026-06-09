package com.example;
import java.util.List;

public class HumanEval_74 {
    public static List<String> totalMatch(List<String> lst1, List<String> lst2) {
        int c1 = 0;
        for (String s : lst1) {
            c1 += s.length();
        }
        
        int c2 = 0;
        for (String s : lst2) {
            c2 += s.length();
        }
        
        return c1 <= c2 ? lst1 : lst2;
    }
}