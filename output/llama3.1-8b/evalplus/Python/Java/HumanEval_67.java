package com.example;
public class HumanEval_67 {
    public static int fruitDistribution(String s, int n) {
        String[] words = s.split(" ");
        int c1 = Integer.parseInt(words[0]);
        int c2 = Integer.parseInt(words[3]);
        if (n - c1 - c2 < 0) {
            throw new IllegalArgumentException("invalid inputs");
        }
        
        return n - c1 - c2;
    }

    public static void main(String[] args) {
        System.out.println(fruitDistribution("5 apples and 6 oranges", 19)); // ->19 - 5 - 6 = 8
        System.out.println(fruitDistribution("0 apples and 1 oranges",3)); // -> 3 - 0 - 1 = 2
        System.out.println(fruitDistribution("2 apples and 3 oranges", 100)); // -> 100 - 2 - 3 = 95
        System.out.println(fruitDistribution("100 apples and 1 oranges",120)); // -> 120 - 100 - 1 = 19
    }
}