package com.example;
public class HumanEval_67 {
    public static void main(String[] args) {
        System.out.println(fruit_distribution("5 apples and 6 oranges", 19));
        System.out.println(fruit_distribution("0 apples and 1 orange", 3));
        System.out.println(fruit_distribution("2 apples and 3 oranges", 100));
        System.out.println(fruit_distribution("100 apples and 1 orange", 120));
    }

    public static int fruit_distribution(String s, int n) {
        String[] words = s.split("\\s+");
        if (words.length < 4 || !isInteger(words[0]) || !isInteger(words[3])) {
            throw new IllegalArgumentException("Invalid inputs");
        }
        
        int c1 = Integer.parseInt(words[0]);
        int c2 = Integer.parseInt(words[3]);

        return n - c1 - c2;
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}