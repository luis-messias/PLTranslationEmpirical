import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class atcoder_ARC102_C {

    static long MOD = 998244353;
    static int __N = 8000;

    // Global arrays for precomputed values
    static long[] fact = new long[__N + 1]; // g1 in Python: factorials
    static long[] invFact = new long[__N + 1]; // g2 in Python: inverse factorials

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
        fact[0] = 1;
        for (int i = 1; i <= __N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        
        // Calculate inverse of N!
        invFact[__N] = modInverse(fact[__N]);

        // Calculate inverse factorials iteratively: (i-1)!^-1 = i!^-1 * i
        for (int i = __N - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    // Combination function C(n, r) % MOD
    static long cmb(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        // C(n, r) = n! / (r! * (n-r)
