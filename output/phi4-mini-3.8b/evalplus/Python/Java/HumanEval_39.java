package com.example;
import java.util.Random;


public class HumanEval_39 {

    public static void main(String[] args) {
        System.out.println(prime_fib(1)); // Output: 2

        System.out.println(prime_fib(2)); // Output: 3

        System.out.println(prime_fib(3)); // Output: 5

        System.out.println(prime_fib(4)); // Output: 13

        System.out.println(prime_fib(5)); // Output: 89
    }


    public static int prime_fib(int n) {

        Random random = new Random();

        boolean miller_rabin(long number, int iterations) {
            if (number < 2)
                return false;

            if (number == 2 || number == 3)
                return true;

            if ((int) number % 2 == 0)
                return false;


            long r = 0;
            long d = number - 1;

            while (d % 2 == 0) {
                ++r;
                d /= 2;
            }


            for (int i = 0; i < iterations; i++) {

                int a = random.nextInt((int)number + 1) + 2;


                long x = power(a, d, number);

                if ((x == 1 || x == number - 1) && r > 1)
                    continue;

                for (int j = 0; j < r - 1; ++j)

                    x = pow(x * x % number, 2, number);


                else

                    return false;


            }

            return true;
        }


        int c_prime = 0;
        long a = 0L;

        long b = 1L;

        while (c_prime < n) {

            if (miller_rabin(b, 10)) {
                ++c_prime;
            }

            a += b;

            b += a;


        }


        return (int)b;
    }


    private static long power(long base, long exponent, int modulus) {

        long result = 1L % modulus;

        while (exponent > 0) {

            if ((exponent & 1) == 1)

                result = (result * base) % modulus;


            exponent >>= 1;

            base = (base * base) % modulus;
        }

        return result;
    }


}