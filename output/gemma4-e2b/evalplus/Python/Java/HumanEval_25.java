package com.example;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class HumanEval_25 {

    public static List<Integer> factorize(int n) {
        List<Integer> fact = new ArrayList<>();
        int currentN = n;
        int i = 2;

        // The loop condition in Python was: while i <= int(math.sqrt(n) + 1):
        // We use the current value of n inside the loop condition check for correctness, 
        // although the Python code uses the original n implicitly in the loop condition check 
        // (which is slightly confusing if n is modified inside). 
        // We will adapt the logic to the standard efficient factorization approach, 
        // which is generally safer and cleaner, while ensuring the result matches the intent.
        
        // Standard optimization: iterate up to sqrt(currentN)
        while (i * i <= currentN) {
            if (currentN % i == 0) {
                fact.add(i);
                currentN = currentN / i;
            } else {
                i++;
            }
        }

        // If currentN is greater than 1, it must be a prime factor itself
        if (currentN > 1) {
            fact.add(currentN);
        }
        
        // Note: The original Python code handles repeated division inside the loop differently.
        // Let's re-implement strictly following the Python logic structure where division happens only once per successful check, 
        // and the loop condition depends on the original sqrt(n).

        // Reverting to the structure implied by the Python code's iterative division:
        
        fact.clear();
        int n_copy = n;
        i = 2;
        
        // We need to calculate the limit based on the original n, or dynamically based on the changing n.
        // Since the Python code modifies n inside the loop and checks i against sqrt(n), 
        // we must ensure the loop termination condition is correctly handled based on the state of n.
        
        // Let's stick to the logic that handles repeated division correctly, which is usually done by checking i*i <= n.
        // If we strictly translate the provided Python logic:
        
        int n_original = n;
        fact.clear();
        i = 2;
        
        // Using Math.sqrt(n_original) for the limit check, as implied by the Python code structure
        int limit = (int) Math.floor(Math.sqrt(n_original)) + 1;
        
        while (i <= limit) {
            if (n % i == 0) {
                fact.add(i);
                n = n / i;
                // Since n changed, we should re-evaluate the limit if we were strictly following the Python structure, 
                // but the Python code uses the initial sqrt(n) + 1 as the bound for i.
                // Let's follow the Python structure exactly, using the modified n for the check inside the loop.
            } else {
                i++;
            }
        }
        
        // The Python code structure is slightly flawed if interpreted literally regarding the loop condition update, 
        // as it relies on the original n's sqrt for the loop bound, but modifies n inside. 
        // The most robust translation that achieves the desired factorization result is the standard one:
        
        fact.clear();
        i = 2;
        int tempN = n;
        
        while (i * i <= tempN) {
            while (tempN % i == 0) {
                fact.add(i