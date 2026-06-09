package com.example;
public class HumanEval_158 {

  public static String findMax(String[] words) {

    int maxCharCount = -1;

    String answer = "";

    for (String word : words) {

      Set<Character> uniqueCharactersSet = new HashSet<>();

      for (char c : word.toCharArray()) {

        uniqueCharactersSet.add(c);

      }

      if (uniqueCharactersSet.size() > maxCharCount || 

          (uniqueCharactersSet.size() == maxCharCount && word.compareTo(answer) < 0)) {

        maxCharCount = uniqueCharactersSet.size();

        answer = word;

      }

    }

    return answer;

  }


  public static void main(String[] args) {

    String result1 = findMax(new String[]{"name", "of", "string"});

    System.out.println(result1); // Output: string

    String result2 = findMax(new String[]{"name", "enam", "game"});

    System.out.println(result2); // Output: enam

    String result3 = findMax(new String[]{"aaaaaaa", "bb", "cc"});

    System.out.println("'" + result3 + "'"); // Output: 'aaaaaaa'

  }

}