import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC132_F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n and k
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        long mod = 1_000_000_007L;

        // 1. Calculate coef
        java.util.ArrayList<Long> coefList = new java.util.ArrayList<>();
        
        // Calculate coefficients based on sqrt(n)
        int limit = (int) Math.sqrt(n);
        for (int i = 1; i <= limit; i++) {
            long term = (n / i) - (n / (i + 1));
            coefList.add(term);
        }

        // Calculate sum of current coefficients
        long currentSum = 0;
        for (long val : coefList) {
            currentSum += val;
        }
        
        // Append 1s until the total length is n
        int remaining = n - (coefList.size());
        for (int i = 0; i < remaining; i++) {
            coefList.add(1L);
        }
        
        // Reverse the list to get the final coef array
        long[] coef = new long[n];
        for (int i = 0; i < n; i++) {
            coef[i] = coefList.get(n - 1 - i);
        }
        
        int nn = n;

        // 2. Dynamic Programming Setup
        // dp[i][j] stores the result for step i and coefficient j
        // Size: (k+1) rows, nn columns
        long[][] dp = new long[k + 1][nn];
        
        // dp[0][0] = 1
        dp[0][0] = 1;

        // 3. DP Calculation
        for (int i = 1; i <= k; i++) {
            long tmp = 0;
            // Iterate j from nn - 1 down to 0
            for (int j = nn - 1; j >= 0; j--) {
                // Index for dp[i-1] is (nn - 1) - j
                int prev_j_index = (nn - 1) - j;
                
                // tmp += dp[i - 1][(nn - 1) - j]
                tmp = (tmp + dp[i - 1][prev_j_index]) % mod;
                
                // dp[i][j] = coef[j] * tmp
                dp[i][j] = (coef[j] * tmp) % mod;
            }
        }

        // 4. Result: sum(dp[k])
        long totalSum = 0;
        for (int j = 0; j < nn; j++) {
            totalSum = (totalSum + dp[k][j]) % mod;
        }

        System