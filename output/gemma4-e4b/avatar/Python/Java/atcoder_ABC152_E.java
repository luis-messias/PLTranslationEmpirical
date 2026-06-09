import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC152_E {

    static final long MOD = 1000000007L;

    // Function to calculate GCD
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate (base^exp) % mod
    public static long power(long base, long exp) {
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

    // Function to calculate modular inverse using Fermat's Little Theorem
    // a^(-1) = a^(MOD - 2) % MOD
    public static long modInverse(long n) {
        return power(n, MOD - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        int N = scanner.nextInt();

        // Read array A
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }
        
        scanner.close();

        // 1. Calculate LCM of all elements
        long lcm_val = 1;
        for (long a : A) {
            // lcm(lcm_val, a) = (lcm_val * a) / gcd(lcm_val, a)
            // To prevent overflow, calculate as (lcm_val / gcd) * a
            long commonDivisor = gcd(lcm_val, a);
            
            // Since lcm_val and a are positive, and we assume the final LCM fits within long
            // We must ensure the multiplication (lcm_val / commonDivisor) * a does not overflow long.
            // Given the constraints are unknown, we proceed with standard long arithmetic, 
            // assuming the intermediate LCM fits.
            lcm_val = (lcm_val / commonDivisor) * a;
        }

        // 2. Calculate the sum of modular inverses: sum(s^(-1)) % MOD
        long sum_inv = 0;
        for (long s : A) {
            long inv = modInverse(s);
            sum_inv = (sum_inv + inv) % MOD;
        }

        // 3. Calculate the final answer: (lcm_val * sum_inv) % MOD
        // Since lcm_val might be much larger than MOD, we