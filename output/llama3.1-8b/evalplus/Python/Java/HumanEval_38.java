package com.example;
public class HumanEval_38 {
    public static String encodeCyclic(String s) {
        String[] groups = new String[(s.length() + 2) / 3];
        for (int i = 0; i < groups.length; i++) {
            int start = 3 * i;
            int end = Math.min(3 * (i + 1), s.length());
            groups[i] = s.substring(start, end);
        }
        StringBuilder result = new StringBuilder();
        for (String group : groups) {
            if (group.length() == 3) {
                result.append(group.substring(1)).append(group.charAt(0));
            } else {
                result.append(group);
            }
        }
        return result.toString();
    }

    public static String decodeCyclic(String s) {
        String[] groups = new String[(s.length() + 2) / 3];
        for (int i = 0; i < groups.length; i++) {
            int start = 3 * i;
            int end = Math.min(3 * (i + 1), s.length());
            groups[i] = s.substring(start, end);
        }
        StringBuilder result = new StringBuilder();
        for (String group : groups) {
            if (group.length() == 3) {
                result.append(group.charAt(2)).append(group.substring(0, 2));
            } else {
                result.append(group);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test the functions
        String encoded = encodeCyclic("HelloWorld");
        System.out.println(encoded);
        String decoded = decodeCyclic(encoded);
        System.out.println(decoded);
    }
}