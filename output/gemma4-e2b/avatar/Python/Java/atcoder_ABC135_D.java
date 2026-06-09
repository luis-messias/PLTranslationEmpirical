import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class atcoder_ABC135_D {

    static long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read S
        String S = br.readLine();
        if (S == null || S.isEmpty()) return;

        int n = S.length();

        if (n == 1) {
            if (S.equals("5") || S.equals("?")) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }

        // dp[i][k]: count of prefixes of length i+1 that are congruent to k mod 13
        // Since n is up to potentially large, we use long for counts and apply modulo.
        long[][] dp = new long[n][13];

        // i = 0 (Base case)
        char c0 = S.charAt(0);
        if (c0 != '?') {
            int d = Character.getNumericValue(c0);
            dp[0][d % 13] = 1;
        } else {
            // If S[0] is '?', it can represent digits 0-9.
            // The Python code adds 1 for each choice, implying 10 possibilities.
            // We must interpret what the DP state means when '?' is present.
            // Based on the Python logic:
            // for j in range(10): dp[0][j] += 1
            // This suggests that if S[0] is '?', it contributes 1 count to all 10 possible remainders (0..9).
            // This interpretation seems highly specific to how the problem defines '?' contribution.
            // Let's follow the Python logic exactly:
            for (int j = 0; j <= 9; j++) {
                dp[0][j] = (dp[0][j] + 1) % MOD;
            }
        }


        // DP transition for i > 0
        for (int i = 1; i < n; i++) {
            char current_char = S.charAt(i);

            for (int k = 0; k < 13; k++) {
                if (dp[i - 1][k] == 0) continue;

                if (current_char != '?') {
                    // Case 1: S[i] is a fixed digit d
                    int d = Character.getNumericValue(current_char);
                    int next_k = (k * 10 + d) % 13;
                    dp[i][next_k] = (dp[i][next_k] + dp[i - 1][k]) % MOD;
                } else {
                    // Case 2: S[i] is '?'
                    // It can be any digit j from 0 to 9.
                    for (int j = 0; j <= 9; j++) {
                        int next_k = (k * 10 + j) % 13;
                        dp[i][next_k] = (dp[i][next_k] + dp[i - 1][k]) % MOD;
                    }
                }
            }
        }

        // The result is dp[n-1][5]
        System.out.println(dp[n - 1][5]);
    }
}