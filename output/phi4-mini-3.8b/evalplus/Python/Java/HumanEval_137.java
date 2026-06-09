package com.example;
public class HumanEval_137 {

  public static Object compareOne(Object a, Object b) {

    double numA = Double.parseDouble(a.toString().replace(",", "."));

    double numB = Double.parseDouble(b.toString().replace(",", "."));

    if (numA == numB) {
      return null;
    }

    return ((Comparable)a).compareTo((Comparable)b);

  }


}