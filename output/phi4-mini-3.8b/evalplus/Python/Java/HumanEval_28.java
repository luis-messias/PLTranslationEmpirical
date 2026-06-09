package com.example;
import java.util.List;

public class HumanEval_28 {

  public static void main(String[] args) {

    System.out.println(concatenate(new ArrayList<String>() {{ add("a"); add("b"); add("c") }}));

  }


  public static String concatenate(List<String> strings) {

    return "".concat(strings);

  }

}