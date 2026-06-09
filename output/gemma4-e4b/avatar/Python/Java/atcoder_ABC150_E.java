import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class atcoder_ABC150_E {

    // Modular exponentiation: (base^exp) % mod
    private static long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n
        int n = scanner.nextInt();
        
        // Read array c (using Long[] to handle potential large values and sorting)
        Long[] c = new Long[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextLong();
        }
        
        // Sort c in descending order
        Arrays.sort(c, Collections.reverseOrder());
        
        long mod = 1000000007L;
        
        // Calculate b = 2^(2n-2) mod mod
        long exponent = 2L * n - 2;
        long b = power(2, exponent, mod);
        
        // Calculate a = 2 * b % mod
        long a = (2 * b) % mod;