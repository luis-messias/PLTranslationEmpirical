import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class atcoder_ABC169_D {

    // Helper function to read a single long integer N from standard input
    private static long readLong(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null || line.isEmpty()) {
            return 0;
        }
        // Use Long.parseLong to handle large inputs
        return Long.parseLong(line.trim());
    }

    /**
     * Prime factorizes n and returns a list of all prime factors (with multiplicity).
     * Handles long input N.
     */
    private static List<Long> primeFactorize(long n) {
        List<Long> factors = new ArrayList<>();
        long tempN = n;

        // Handle factor 2
        while (tempN % 2 == 0) {
            factors.add(2L);
            tempN /= 2;
        }

        // Handle odd factors
        // f*f <= tempN requires careful casting to avoid overflow if f and tempN are large longs
        for (long f = 3; f * f <= tempN; f += 2) {
            while (tempN % f == 0) {
                factors.add(f);
                tempN /= f;
            }
        }

        // If tempN is a prime greater than 2
        if (tempN != 1) {
            factors.add(tempN);
        }
        return factors;
    }

    public static void main(String[] args) throws IOException {
        // Using BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N (must use long)
        long n = readLong(br);

        if (n == 1) {
            System.out.println(0);
            return;
        }

        // 1. Prime Factorization
        List<Long> facList = primeFactorize(n);

        // 2. Count factor frequencies (Equivalent to Counter(fac_))
        // Key: Prime factor (Long), Value: Exponent (Integer, since max exponent is small)
        Map<Long, Integer> fac = new HashMap<>();
        for (long factor : facList) {
            // We only care about the count, so we use the factor itself as the key
            fac.put(factor, fac.getOrDefault(factor, 0) + 1);
        }

        // 3. Main calculation loop
        long ans = 0;
        
        // Iterate over prime factors (p) and their exponents (e)
        for (Map.Entry<Long, Integer> entry : fac.entrySet()) {
            // p is the prime (unused in the loop logic, but kept for clarity)
            // long p = entry.getKey(); 
            
            // e is the exponent (initial value for x)
            int e = entry.getValue();
            
            // x represents the current remaining exponent count
            int x = e;
            
            // Loop limit is 99,999,999
            // i is the counter for the subtraction sequence
            for (int i = 1; i < 99999999; i++) {
                if (x >= i) {
                    x -= i;
                    ans += 1;
                } else {
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
