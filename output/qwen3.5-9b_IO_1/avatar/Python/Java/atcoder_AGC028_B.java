import java.util.Scanner;

public class atcoder_AGC028_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = 1000000;
        long MOD = 1000000007L;
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }
        
        int Nsq = 1000;
        long[][] fact = new long[Nsq][Nsq];
        
        // Initialize first row with factorials
        fact[0][0] = 1;
        for (int n = 1; n < Nsq; n++) {
            fact[0][n] = fact[0][n - 1] * n % MOD;
        }
        
        // Compute inverse factorials in first column
        for (int n = 1; n < Nsq; n++) {
            fact[n][0] = fact[n - 1][0] * power(n, MOD - 2, MOD) % MOD;
        }
        
        // Flatten and compute
        long[] flatFact = new long[Nsq * Nsq];
        int idx = 0;
        for (int i = 0; i < Nsq; i++) {
            for (int j = 0; j < Nsq; j++) {
                flatFact[idx++] = fact[i][j];
            }
        }
        
        long[] inv = new long[N];
        for (int i = 0; i < N; i++) {
            inv[i] = power(i + 1, MOD - 2, MOD);
        }
        
        long[] cumInv = new long[N];
        cumInv[0] = inv[0];
        for (int i = 1; i < N; i++) {
            cumInv[i] = (cumInv[i - 1] + inv[i]) % MOD;
        }
        
        long temp = 0;
        for (int i = 0; i < N; i++) {
            temp = (cumInv[i] + cumInv[N - 1 - i] - 1) % MOD;
            if (temp < 0) temp += MOD;
        }
        
        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans = (ans + A[i] * temp) % MOD;
        }
        
        ans = ans * fact[N - 1][0] % MOD;
        ans = (ans + MOD) % MOD;
        
        System.out.println(ans);
    }
    
    static long power(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
