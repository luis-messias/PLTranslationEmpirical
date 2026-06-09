package com.example;
public static int digits(int n) {
    boolean hasOdd = false;
    int prod = 1;
    while (n > 0) {
        int digit = n % 10;
        if (digit % 2 == 1) {
            hasOdd = true;
            prod *= digit;
        }
        n /= 10;
    }
    return hasOdd ? prod : 0;
}