import java.util.Scanner;

public class atcoder_ABC129_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String l = scanner.nextLine();
        scanner.close();

        long mod = 1_000_000_007L;
        int n = l.length();

        // dp[i][0] and dp[i][1] store the counts for the prefix of length i
        long[][] dp = new long[n + 1][2];

        // Base case: dp[0][0] = 1
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            char c = l.charAt(i);
            
            // Initialize dp[i+1] for the current step
            dp[i + 1][0] = 0;
            dp[i + 1][1] = 0;

            if (c == '0') {
                // Case c == '0'
                
                // dp[i+1][0] += dp[i][0]
                dp[i + 1][0] = (dp[i + 1][0] + dp[i][0]) % mod;
                
                // dp[i+1][1] += dp[i][1] * 3
                long term2 = (dp[i][1] * 3) % mod;
                dp[i + 1][1] = (dp[i + 1][1] + term2) % mod;
            } else {
                // Case c != '0' (assuming '1')
                
                // dp[i+1][0] += dp[i][0] * 2
                long term0 = (dp[i][0] * 2) % mod;
                dp[i + 1][0] = (dp[i + 1][0] + term0) % mod;

                // dp[i+1][1] += dp[i][0]
                dp[i + 1][1] = (dp[i + 1][1] + dp[i][0]) % mod;

                // dp[i+1][1] += dp[i][1] * 3
                long term1_2 = (dp[i][1] * 3) % mod;
                dp[i + 1][1] = (dp[i + 1][1] + term1_2) % mod;
            }
        }

        // Result: (dp[n][0] + dp[n][1]) % mod
        long result = (dp[n][0] + dp[n][1]) % mod;
        System.out.println(result);
    }
}