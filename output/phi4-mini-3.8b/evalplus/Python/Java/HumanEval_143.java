package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_143 {

    public static void main(String[] args) {
        String sentence1 = "This is a test";
        System.out.println(wordsInSentence(sentence1)); // Output: "is"

        String sentence2 = "lets go for swimming";
        System.out.println(wordsInSentence(sentence2)); // Output: "go for"
    }

    public static String wordsInSentence(String sentence) {
        List<String> primeLengthWordsList = new ArrayList<>();
        
        if (sentence != null && !sentence.isEmpty()) {
            String[] words = sentence.split(" ");
            
            for (String word : words) {
                int lengthOfWord = word.length();
                
                // Check whether the number is a non-negative integer greater than 1
                boolean primeNumber = true;
                if (lengthOfWord >= 2 && !isPrime(lengthOfWord)) {
                    primeNumber = false;
                }
                
                if (primeNumber) {
                    primeLengthWordsList.add(word);
                }
            }
        }

        StringBuilder resultString = new StringBuilder();
        
        for (int i = 0; i < primeLengthWordsList.size(); i++) {
            int indexOfWordInSentence = sentence.indexOf(primeLengthWordsList.get(i));
            
            if(indexOfWordInSentence != -1) { // Check whether the word is found in original string
                resultString.append(sentence.substring(indexOfWordInSentence, indexOfWordInSentence + primeLengthWordsList.get(i).length()));
                
                int nextIndex = sentence.indexOf(primeLengthWordsList.get(i), indexOfWordInSentence);
                if(nextIndex != -1) {
                    // Add space between words
                    resultString.append(" ");
                }
            } else { 
                System.out.println("Error: The word '" + primeLengthWordsList.get(i) + "' was not found in the original sentence.");
            }
        }

        return resultString.toString();
    }


    private static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        
        for (int i = 2; i * i <= num; ++i) {
            if (num % i == 0)
                return false;
        }
        
        return true;
    }

}