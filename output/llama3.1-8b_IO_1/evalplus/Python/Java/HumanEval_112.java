package com.example;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HumanEval_112 {
    public static void main(String[] args) {
        System.out.println(reverseDelete("abcde", "ae"));
        System.out.println(reverseDelete("abcdef", "b"));
        System.out.println(reverseDelete("abcdedcba", "ab"));
    }

    public static String[] reverseDelete(String s, String c) {
        return new String[]{s.replaceAll("[^" + Pattern.quote(String.join("", c.split(""))).replace("*","") + "]","").replaceAll("^|.$", ""), 
                            Boolean.toString(s.replaceAll("[^" + Pattern.quote(String.join("", c.split(""))).replace("*","") + "]","").equals(new StringBuilder(s.replaceAll("[^" + Pattern.quote(String.join("", c.split(""))).replace("*","") + "]","")).reverse().toString()))};
    }
}
