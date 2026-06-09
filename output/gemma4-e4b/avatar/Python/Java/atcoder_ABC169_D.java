import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;

public class atcoder_ABC169_D {

    // Helper function to read a single integer N from standard input
    private static int readInt(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null || line.isEmpty()) {
            return 0; // Handle empty input case if necessary
        }
        return Integer.parseInt(line.trim());
    }

    /**
     * Prime factorizes n and returns a list of all prime factors (with multiplicity).
     * Equivalent to Python's prime_factorize.
     */
    private static List<Integer> primeFactorize(int n) {
        List<Integer> factors = new ArrayList<>();
        int tempN = n;

        // Handle factor 2
        while (tempN % 2 == 0) {
            factors.add(2);
            tempN /= 2;
        }

        // Handle odd factors
        for (int f = 3; f * f <= tempN; f += 2) {
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

        // Read N (equivalent to n = int(input()))
        int n = readInt(br);

        if (n == 1) {
            System.out.println(0);
            return;
        }

        // 1. Prime Factorization
        List<Integer> facList = primeFactorize(n);

        // 2. Count factor frequencies (Equivalent to Counter(fac_))
        Map<Integer, Integer> fac = new HashMap<>();
        for (int factor : facList) {
            fac.put(factor, fac.getOrDefault(factor, 0) + 1);
        }

        // 3. Main calculation loop
        long ans = 0;
        
        // Iterate over prime factors (p) and their exponents (e)
        for (Map.Entry<Integer, Integer> entry : fac.entrySet()) {
            // p is the prime, e is the exponent
            // Note: The Python code uses 'e' as the initial value for 'x'
            int e = entry.getValue();
            int x = e;
            
            // Loop limit is 99,999,999
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