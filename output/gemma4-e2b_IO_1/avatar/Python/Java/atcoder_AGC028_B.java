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
        
        // Read N
        String lineN = br.readLine();
        if (lineN == null) return;
        int N = Integer.parseInt(lineN.trim());

        // Read M (M = 10^6) - Read but not strictly used in the final calculation structure based on N
        // We read the next line which is likely M=10^6, but the Python code reads it implicitly via input()
        // We skip reading M explicitly if it's just a constant setup, focusing on reading A.
        
        // Read A
        String A_line = br.readLine();
        if (A_line == null) return;
        StringTokenizer st = new StringTokenizer(A_line);
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            if (st.hasMoreTokens()) {
                A[i] = Long.parseLong(st.nextToken());
            } else {
                // Handle case where input line might be shorter than expected, though unlikely in CP context
                return;
            }
        }

        long MOD = 1000000007L;

        // --- Factorial setup (Replicating the complex NumPy setup) ---
        // The Python code sets up a 1000x1000 factorial matrix based on M=10^6.
        // Since the final calculation only uses fact[N], we only need N! mod MOD.
        
        // Calculate
