package com.example;
import java.util.List;

public class HumanEval_3 {

    public static boolean belowZero(List<Integer> operations) {

        int account = 0;

        for (int operation : operations) {

            account += operation;

            if (account < 0) {

                return true;

            }

        }

        return false;

    }


    public static void main(String[] args) {

        System.out.println(belowZero(List.of(1, 2, 3))); // False

        System.out.println(belowZero(List.of(1, 2, -4, 5))); // True

    }

}