import java.util.Scanner;
import java.lang.Math;

public class s840967243 {

    // Function to calculate factorial modulo MOD
    static long factorial(long n, long mod) {
        if (n < 0) return 0;
        long res = 1;
        for (long i = 2; i <= n; i++) {
            res = (res * i) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m from input
        if (!scanner.hasNextLong()) {
            scanner.close();
            return;
        }
        long n = scanner.nextLong();
        if (!scanner.hasNextLong()) {
            scanner.close();
            return;
        }
        long m = scanner.nextLong();
        
        scanner.close();

        long MOD = 1000000007L;

        // Python: n, m = sorted(map(int, input().split()))
        // The Python code sorts them, but the formula uses n and m directly. We use the read values.
        
        // Python: max(2 - m + n, 0)
        long factor = Math.max(2 - m + n, 0);

        // Python: f(n) and f(m)
        long factN = factorial(n, MOD);
        long factM = factorial(m, MOD);

        // Python: max(...) * f(n) * f(m) % MOD
        // We must ensure intermediate multiplication stays within long bounds before the final modulo.
        long result = (factor % MOD * factN) % MOD;
        result = (result * factM) % MOD;

        System.out.println(result);
    }
}
