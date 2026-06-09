import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class atcoder_AGC028_B {

    static final long MOD = 1_000_000_007L;

    // Modular exponentiation: (base^exp) % mod
    private static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    // Modular inverse using Fermat's Little Theorem: a^(MOD-2) % MOD
    private static long modInverse(long n) {
        return power(n, MOD - 2);
    }

    public static