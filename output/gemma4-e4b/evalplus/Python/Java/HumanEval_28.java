package com.example;
import java.util.List;

public class HumanEval_28 {
    /**
     * Concatenate list of strings into a single string
     * @param strings The list of strings to concatenate.
     * @return The concatenated string.
     */
    public static String concatenate(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }
}