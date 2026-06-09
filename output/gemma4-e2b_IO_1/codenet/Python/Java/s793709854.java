import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class s793709854 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and T
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int T = scanner.nextInt();

        // Read L matrix (N rows, 2 columns)
        int[][] L = new int[N][2];
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                L[i][0] = scanner.nextInt(); // Length
                L[i][1] = scanner.nextInt(); // Value
            }
        }

        // dp[i][j]: Max value using first i items with total length j
        // Size (N+1) x T
        int[][] dp = new int[N + 1][T];

        // DP calculation
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < T; j++) {
                // Case 1: Item i is not included (or capacity j is too small)
                dp[i + 1][j] = dp[i][j];

                // Case 2: Item i is included
                if (j >= L[i][0]) {
                    // Compare skipping vs including
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j - L[i][0]] + L[i][1]);
                }
            }
        }

        // The Python code uses dp[i+1][j] = max(dp[i][j], dp[i][j-L[i][0]]+L[i][1])
        // Let's re-implement the DP exactly as written in Python, ensuring we handle the indices correctly.
        
        // Reset DP for exact translation of the original logic structure
        dp = new int[N + 1][T];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < T; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < T; j++) {
                // dp[i+1][j] calculation based on dp[i][...]
                if (j < L[i][0]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    // Option 1: Skip item i (dp[i][j])
                    // Option 2: Include item i (dp[i][j - L[i][0]] + L[i][1])
                    dp[i + 1][j] = Math.max(dp[i][j], dp
