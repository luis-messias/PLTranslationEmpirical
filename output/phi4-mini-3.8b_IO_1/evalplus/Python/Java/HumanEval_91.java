package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_91 {

  public static int isBored(String S) {
      String[] delimiters = {".", "?", "!"};

      for (String delimiter : delimiters) {
          if (!S.contains(delimiter)) break; // Stop replacing when no more replacements are needed

          S = S.replace(delimiter, ".");
      }

      List<String> sentences = Arrays.stream(S.split("\\."))
                                     .map(sentence -> sentence.trim())
                                     .collect(Collectors.toList());

      return (int) Arrays.stream(sentences)
                         .filter(s -> s.startsWith("I "))
                         .count();
  }

  public static void main(String[] args) {
      System.out.println(isBored("Hello world")); // Output: 0

      System.out.println(isBored("The sky is blue. The sun is shining. I love this weather"));
      // Expected output would be the count of sentences starting with "I "
  }
}
