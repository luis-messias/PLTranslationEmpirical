package com.example;
public class HumanEval_49 {

    public static int modp(int n, int p) {

        long res = 1;

        long x = 2;


        while (n != 0) {

            if ((n & 1) == 1) { // Check for odd using bitwise AND operator.

                res = (res * x % p);

            }

            x = (x * x % p);


            n >>>= 1; // Right shift to divide by two.


        }


        return (int)(res % p); // Cast back and modulo as per original function signature

    }



}