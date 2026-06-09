import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;
import java.util.stream.Stream;

public class atcoder_AGC019_A {

    // Helper function implementations (translated from Python utilities)

    // GCD using Euclidean algorithm
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // LCM
    private static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        // Use Math.abs to handle potential negative inputs, though context suggests positive
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
        return (a + b - 1) / b;
    }

    // Rounding: int((x * 2 + 1) / 2)
    private static long round(double x) {
        // Since the Python version returns int, we cast to long
        return (long) ((x * 2 + 1) / 2);
    }

    // --- Input Handling Simulation ---
    // In Java, we simulate the input reading process using Scanner.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read q, h, s, d (Simulating MAP())
        // Assuming the input provides four space-separated integers on the first line.
        if (!scanner.hasNextLine()) {
            return;
        }
        String line1 = scanner.nextLine();
        String[] parts = line1.trim().split("\\s+");

        if (parts.length < 4) {
            // Handle case where not enough inputs are provided
            return;
        }

        long q = Long.parseLong(parts[0]);
        long h = Long.parseLong(parts[1]);
        long s = Long.parseLong(parts[2]);
        long d = Long.parseLong(parts[3]);

        // 2. Read n (Simulating INT())
        long n;