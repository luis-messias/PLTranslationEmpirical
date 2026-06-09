import java.util.Scanner;
import java.util.Arrays;

public class atcoder_AGC004_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and x
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        if (!scanner.hasNextInt()) return;
        long x = scanner.nextLong(); // x might be large, though it's read as int in Python context

        // Read array a
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLong()) return;
            a[i] = scanner.nextLong();
        }

        // Initialize b (n x n matrix)
        // In Python, None was used. In Java, we use a large value or handle initialization carefully.
        // Since the calculation involves finding minimums, initializing with a very large value is appropriate.
        long[][] b = new long[n][n];
        
        // The Python code initializes b with None, implying the subsequent loop fills it.
        // We initialize it to a large value to ensure min operations work correctly.
        long INF = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Arrays.fill(b[i], INF);
        }

        // Calculate b
        for (int i = 0; i < n; i++) {
            long m = a[i];
            for (int j = 0; j < n; j++) {
                // k = i - j (modulo n)
                int k = i - j;
                if (k < 0) {
                    k += n;
                }
                
                // m = min(m, a[k])
                m = Math.min(m, a[k]);
                
                // b[j][i] = m
                b[j][i] = m;
            }
        }

        // Final calculation
        long m = Long.MAX_VALUE; // Equivalent to 10**15 for practical purposes in min operations
        
        for (int i = 0; i < n; i++) {
            long sum_j = 0;
            for (int j = 0; j < n; j++) {
                sum_j += b[j][i];
            }
            
            // m = min(m, sum(j) + x * i)
            long current_val = sum_j + x * i;
            m = Math.min(m, current_val);
        }

        System.out.println(m);
        scanner.close();
    }
}