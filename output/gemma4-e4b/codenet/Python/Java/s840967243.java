import java.util.Scanner;
import java.lang.Math;

public class s840967243 {

    static final long MOD = 1_000_000_007L;

    /**
     * Calculates k! mod MOD
     */
    public static long factorial(int k) {
        long result = 1;
        for (int i = 2; i <= k; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the two integers A and B
        if (!scanner.hasNextInt()) return;
        int a = scanner.nextInt();
        
        if (!scanner.hasNextInt()) return;
        int b = scanner.nextInt();
        
        // Python sorts them: n = min(a, b), m = max(a, b)
        int n = Math.min(a, b);
        int m = Math.max(a, b);
        
        // Calculate the multiplier: max(2 - m + n, 0)
        // Since n <= m, m - n >= 0.
        long diff = (long)m - n;
        long term1 = 2 - diff;
        long multiplier = Math.max(term1, 0);
        
        // Calculate n! * m! mod MOD
        long factN = factorial(n);
        long factM = factorial(m);
        
        // Result = multiplier * factN * factM mod MOD
        
        // Step 1: (multiplier % MOD)
        long result = multiplier % MOD;
        
        // Step 2: result * factN % MOD
        result = (result * factN) % MOD;
        
        // Step 3: result * factM % MOD
        result = (result * factM) % MOD;
        
        System.out.println(result);
        
        scanner.close();
    }
}