package com.example;
public class HumanEval_99 {

    public static void main(String[] args) {

        System.out.println(closestInteger("10")); // Output: 10

        System.out.println(closestInteger("15.3")); // Output: 15


        System.out.println(closestInteger("14.5")); // Output: 15

        System.out.println(closestInteger("-14.5")); // Output: -15
    }


    public static int closestInteger(String value) {

        double val = Double.parseDouble(value);

        if (Math.abs(val - Math.round(val)) != 0.5) {
            return (int)Math.round(val);
        }

        if (val > 0) {
            return (int)(val + 1);

        } else { // val < 0

            return (int)(val - 1);

        }

    }

}