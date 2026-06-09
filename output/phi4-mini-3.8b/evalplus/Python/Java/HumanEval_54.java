package com.example;
import java.util.Set;
import java.util.HashSet;


public class HumanEval_54 {

  public static boolean sameChars(String s0, String s1) {

      Set<Character> charSetS0 = new HashSet<>();

      for (char c : s0.toCharArray()) {
          charSetS0.add(c);

      }

      Set<Character> charSetS1 = new HashSet<>();

      for (char c : s1.toCharArray()) {
          charSetS1.add(c);

      }


      return characterSetsEqual(charSetS0, charSetS1);


  }


  private static boolean characterSetsEqual(Set<Character> setA, Set<Character> setB) {

      if(setA.size() != setB.size()) {

          return false;

      }

      for (Character c : setA) {

          if (!setB.contains(c)) {

              return false;

          }

      }


      return true;


  }


}