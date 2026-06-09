package com.example;
public static int digitSum(String s) {
    int sum = 0;
    for (char ch : s.toCharArray()) {
        if (Character.isUpperCase(ch)) {
            sum += ch;
        }
    }
    return sum;
}