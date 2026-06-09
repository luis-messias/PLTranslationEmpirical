package com.example;
public class HumanEval_128 {

    public static int prod_signs(int[] arr) {

        if (arr.length == 0) return null;

        boolean containsZero = false;
        long sumOfMagnitudes = 0, productOfSigns = 1L;


        for (int x : arr) {

            if (x != 0) {
                int sign = ((x > 0) ? 1 : -1);

                sumOfMagnitudes += Math.abs(x);
                productOfSigns *= sign;

                containsZero |= (x == 0); // Check and mark presence of zero

            }

        }


        if (containsZero || arr[0] < 0 && !arr.contains(0)) return 0;


        int result = sumOfMagnitudes * ((int)productOfSigns);

        return result;

    }


    public static void main(String[] args) {

        System.out.println(prod_signs(new int[]{1, 2, 2, -4}) == -9 ? "Test passed" : "Test failed");

        System.out.println(prod_signs(new int[]{0, 1}) == 0 ? "Test passed" : "Test failed");

        System.out.println(prod_signs(new int[]{}) == null ? "Test passed" : "Test failed");

    }

}