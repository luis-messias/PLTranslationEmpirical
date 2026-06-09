package com.example;
import java.util.Arrays;

public class HumanEval_20 {

  public static void main(String[] args) {
      int[][] testCases = { 
          new int[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, (int)(2.2)},
          new int[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, (int)(2.0)}
      };

      for (int[] testCase : testCases) {
          double[] numbers = Arrays.stream(testCase).asDoubleStream().toArray();

          int[] result = findClosestElements(numbers);

          System.out.println(Arrays.toString(result));
      }
  }

  public static int[] findClosestElements(double[] numbers) {

    Arrays.sort((double[])numbers.clone());

    double minDiff = Double.MAX_VALUE;

    for (int i = 0; i < numbers.length - 1; ++i) {
        if ((numbers[i + 1] - numbers[i]) > 0 && Math.abs(numbers[i + 1] - numbers[i]) < minDiff)
            minDiff = Math.abs(numbers[i + 1] - numbers[i]);
    }

    int[] closestPair = new int[2];

    for (int i = 0; i < numbers.length - 1; ++i) {
        if ((numbers[i + 1] - numbers[i]) > 0 && Math.abs(numbers[i + 1] - numbers[i]) == minDiff)
            { 
                closestPair[0] = (int)(Math.round(numbers[i]));
                closestPair[1] = (int)(Math.round(numbers[i + 1]));
            }
    }

    return closestPair;
  }
}
