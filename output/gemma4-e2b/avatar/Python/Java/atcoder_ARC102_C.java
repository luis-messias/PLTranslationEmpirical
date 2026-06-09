import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class atcoder_ARC102_C {

    static long MOD = 998244353;
    static int __N = 8000;

    // Global arrays/lists equivalent to Python globals
    static long[] g1 = new long[__N + 1]; // Factorials
    static long[] g2 = new long[__N + 1]; // Inverse factorials
    static long[] inverse = new long[__N + 1];

    // Helper function for modular exponentiation (a^b % mod)
    static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    // Helper function for modular inverse (a^-1 % mod) using Fermat's Little Theorem
    static long modInverse(long n) {
        return power(n, MOD - 2);
    }

    // Precomputation of factorials and inverse factorials
    static void precompute() {
        g1[0] = 1;
        g2[0] = 1;
        inverse[0] = 1;

        for (int i = 1; i <= __N; i++) {
            // g1[i] = i!
            g1[i] = (g1[i - 1] * i) % MOD;

            // Calculate inverse[i] = (i!)^-1 using Fermat's Little Theorem
            // Note: The Python code used an iterative approach for inverses, 
            // but for simplicity and robustness in Java, we use the standard modular inverse calculation here, 
            // which is equivalent if we calculate inverses iteratively based on the previous one.
            // Since the Python code explicitly calculated inverses iteratively, we replicate that structure if possible.
            
            // Replicating the Python inverse calculation logic:
            // inverse[i] = -inverse[i-1] * (mod // i) % mod
            // This specific formula seems tailored for calculating inverses iteratively, 
            // assuming inverse[i-1] is the inverse of (i-1)!
            
            // Let's stick to the standard approach for clarity and correctness in Java, 
            // ensuring we have the necessary inverses for the cmb function.
            
            // We calculate inverse[i] = (i