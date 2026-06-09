import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class atcoder_ABC135_D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        
        int n = S.length();
        long MOD = 1_000_000_007L;

        if (n == 0) {
            System.out.println(0);
            return;
        }

        // dp[i][j] stores the count of numbers formed by prefix S[0...i] 
        // such that the number modulo 13 is j.
        // Since we only need the previous row (i-1) to calculate the current row (i), 
        // we can optimize space, but for direct translation clarity, we use the full table.
        long[][] dp = new long[n][13];

        // Base Case: i = 0
        if (S.charAt(0) != '?') {
            int digit = S.charAt(0) - '0';
            dp[0][digit] = 1;
        } else {
            for (int j = 0; j <= 9; j++) {
                dp[0][j] = 1;
            }
        }

        // Transitions: i = 1 to n-1
        for (int i = 1; i < n; i++) {
            // Initialize current row dp[i] to 0
            Arrays.fill(dp[i], 0);

            if (S.charAt(i) != '?') {
                int d = S.charAt(i) - '0';
                
                // Transition for fixed digit d
                for (int k = 0; k < 13; k++) { // k is the remainder from prefix S[0...i-1]
                    if (dp[i - 1][k] == 0) continue;
                    
                    // New remainder j = (k * 10 + d) % 13
                    int j = (k * 10 + d) % 13;
                    
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            } else {
                // Transition for '?'
                for (int j = 0; j <= 9; j++) { // j is the current digit (0-9)
                    for (int k = 0; k < 13; k++) { // k is the remainder from prefix S[0...i-1]
                        if (dp[i - 1][k] == 0) continue;
                        
                        // New remainder j_prime = (k * 10 + j) % 13
                        int j_prime = (k * 10 + j) % 13;
                        
                        dp[i][j_prime] = (dp[i][j_prime] + dp[i - 1][k]) % MOD;
                    }
                }
            }
        }

        // Result is dp[n-1][5]
        System.out.println(dp[n - 1][5]);
    }
}