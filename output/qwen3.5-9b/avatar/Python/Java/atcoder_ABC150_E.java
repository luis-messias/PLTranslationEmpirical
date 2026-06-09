import java.util.*;

public class atcoder_ABC150_E {
    public static void main(String[] args) {
        long mod = 1000000007L;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] c = new long[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextLong();
        }
        Arrays.sort(c);
        // Reverse the array to get descending order
        for (int i = 0; i < n / 2; i++) {
            long temp = c[i];
            c[i] = c[n - 1 - i];
            c[n - 1 - i] = temp;
        }
        
        // Calculate b = 2^(2n-2) mod mod
        long b = power(2, 2L * n - 2, mod);
        long a = (2 * b) % mod;
        long ans = 0;
        
        for (int i = 0; i < n; i++) {
            ans = (ans + c[i] * (a + i * b)) % mod;
        }
        
        System.out.println(ans);
    }
    
    public static long power(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
}