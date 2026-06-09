import java.util.Scanner;

public class atcoder_AGC046_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read A, B, C, D from input
        if (!scanner.hasNextInt()) {
            return;
        }
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();

        long m = 998244353;

        // Initialize DP table d[C+1][D+1]
        // Use long for the DP table elements to handle intermediate calculations safely, 
        // although the final result fits in int if m is the modulus.
        long[][] d = new long[C + 1][D + 1];

        // Base case
        d[A][B] = 1;

        // DP transition
        for (int i = A; i <= C; i++) {
            for (int j = B; j <= D; j++) {
                // Calculate the term to add: (d[i][j-1] * i + d[i-1][j] * j - d[i-1][j-1] * (i-1) * (j-1)) % m
                
                long term1 = (d[i][j - 1] * i) % m;
                long term2 = (d[i - 1][j] * j) % m;
                long term3 = (d[i - 1][j - 1] * (long)(i - 1) * (j - 1)) % m;
                
                // Calculate the difference: (term1 + term2 - term3) % m
                long update = (term1 + term2 - term3) % m;

                // Ensure the result is non-negative (handling potential negative results from modulo)
                if (update < 0) {
                    update += m;
                }
                
                d[i][j] = (d[i][j] + update) % m;
            }
        }

        // Print the result
        System.out.println(d[C][D]);
        
        scanner.close();
    }
}
