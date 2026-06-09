import java.util.Scanner;
import java.lang.Math;

public class atcoder_AGC019_A {

    // GCD using Euclidean algorithm
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    // LCM
    private static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        // Since inputs are expected to be positive based on context, Math.abs is mostly defensive.
        return Math.abs(a * b) / gcd(Math.abs(a), Math.abs(b));
    }

    // Modular exponentiation (a^b % mod)
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

    // Fermat's Little Theorem inverse: x * y^(MOD-2) % MOD
    private static long fermat(long x, long y, long MOD) {
        // Assuming MOD is prime
        return (x * power(y, MOD - 2, MOD)) % MOD;
    }

    // Ceiling division: ceil(a / b)
    private static long ceil(long a, long b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        // Standard integer ceiling division formula: (a + b - 1) / b
        if ((a >= 0 && b > 0) || (a <= 0 && b < 0)) {
             return (a + b - 1) / b;
        } else {
            // Handle mixed signs or negative inputs if necessary, but assuming positive context here.
            return (a + b - 1) / b;
        }
    }

    // Rounding: int((x * 2 + 1) / 2)
    private static long round(double x) {
        // Since the Python version returns int, we cast to long
        return (long) Math.floor(x * 2.0 + 1.0) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read q, h, s, d (Simulating MAP())
        if (!scanner.hasNextLine()) {
            return;
        }
        String line1 = scanner.nextLine();
        String[] parts = line1.trim().split("\\s+");

        if (parts.length < 4) {
            return;
        }

        long q = Long.parseLong(parts[0]);
        long h = Long.parseLong(parts[1]);
        long s = Long.parseLong(parts[2]);
        long d = Long.parseLong(parts[3]);

        // 2. Read n (Simulating INT())
        if (!scanner.hasNextLine()) {
            return;
        }
        long n = Long.parseLong(scanner.nextLine());

        // --- Core Logic ---

        // best1L = min(q * 4, h * 2, s)
        long best1L = Math.min(q * 4, Math.min(h * 2, s));

        // best2L = min(d, best1L * 2)
        long best2L = Math.min(d, best1L * 2);

        long result;
        
        // If n is even: print(best2L * (n // 2))
        if (n % 2 == 0) {
            result = best2L * (n / 2);
        } 
        // If n is odd: print(best2L * (n // 2) + best1L)
        else {
            result = best2L * (n / 2) + best1L;
        }

        System.out.println(result);
    }
}
