package com.example;
public class HumanEval_79 {
    
    public static String decimalToBinary(int decimal) {
        // Convert integer value into binary string representation.
        String binaryString = Integer.toBinaryString(decimal);
        
        // Add 'db' at both ends of the resulting binary string to match required format.
        return "db" + binaryString + "db";
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(15));  // Output: db1111db
        System.out.println(decimalToBinary(32));  // Output: db100000db
    }
}