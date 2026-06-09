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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N
        String lineN = br.readLine();
        if (lineN == null || lineN.isEmpty()) return;
        int N = Integer.parseInt(lineN.trim());

        // Read array A
        long[] A = new long[N];
        String lineA = br.readLine();
        if (lineA == null || lineA.isEmpty()) return;
        
        StringTokenizer st = new StringTokenizer(lineA);
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        // 1. Precalculate factorials up to N
        long[] fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++)
