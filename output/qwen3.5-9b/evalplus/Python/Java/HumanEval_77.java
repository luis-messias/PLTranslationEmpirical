package com.example;
public static boolean isCube(int a) {
    /**
     * Write a function that takes an integer a and returns True 
     * if this integer is a cube of some integer number.
     * Note: you may assume the input is always valid.
     * Examples:
     * isCube(1) ==> true
     * isCube(2) ==> false
     * isCube(-1) ==> true
     * isCube(64) ==> true
     * isCube(0) ==> true
     * isCube(180) ==> false
     */
    a = Math.abs(a);
    int root = Math.round(Math.pow(a, 1.0 / 3.0));
    return root * root * root == a;
}