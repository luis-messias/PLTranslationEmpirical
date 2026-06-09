package com.example;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HumanEval_143 {
    public static String wordsInSentence(String sentence) {
        return Stream.of(sentence.split(" "))
                .filter(word -> isPrime(word.length()))
                .collect(Collectors.joining(" "));
    }

    private static boolean isPrime(int a) {
        if (a < 2) return false;
        for (int x = 2; x <= Math.sqrt(a); x++) {
            if (a % x == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordsInSentence("This is a test"));
        System.out.println(wordsInSentence("lets go for swimming"));
    }
}