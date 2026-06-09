import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class atcoder_AGC028_B {

    static long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    static long modInverse(long n, long mod) {
        return power(n, mod - 2, mod);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long MOD = 1000000007L;

        // Read N
        String line = br.readLine();
        if (line == null) return;
        int N = Integer.parseInt(line.trim());

        // Read M (M is 10^6, used for factorial setup)
        // M is defined but not directly used in the final calculation structure based on N.
        // We read it just to match the Python structure, although it seems irrelevant if N is small.
        long M = 1000000L; 

        // Read A
        String A_line = br.readLine();
        StringTokenizer st = new StringTokenizer(A_line);
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        // --- Factorial setup (Replicating the complex NumPy setup) ---
        // Since the final result only depends on N and A, and the factorial setup seems to calculate N!
        // we focus on calculating N! correctly modulo MOD.
        
        // fact[n] will store n! mod MOD
        long[] fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i