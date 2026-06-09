package com.example;
import java.util.Arrays;


public class HumanEval_20 {

  public static void main(String[] args) {

      int[][] testCases = { 

          new int[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 2.2f},

          new int[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 2.0f}

      };

      for (int[] testCase : testCases) {

          double[] numbers = Arrays.stream(testCase).asDoubleStream().toArray();

          int[] result = findClosestElements(numbers);

          System.out.println(Arrays.toString(result));

      }

  }


  public static int[] findClosestElements(double[] numbers) {

      Arrays.sort(numbers);


      double minDiff = Double.MAX_VALUE;

      int[] closestPair = null;


      for (int i = 0; i < numbers.length - 1; i++) {

          double diff = Math.abs(numbers[i + 1] - numbers[i]);

          if (diff < minDiff) {

              minDiff = diff;

              closestPair = new int[]{(int)(numbers[i]), (int)(numbers[i + 1])};

          }

      }


      return closestPair;


  }

}