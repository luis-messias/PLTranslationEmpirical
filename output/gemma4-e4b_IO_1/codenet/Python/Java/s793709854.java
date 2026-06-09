import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class s793709854 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and T
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        int T = scanner.nextInt();

        // Read L (N items, each with [weight, value])
        int[][] L = new int[N][2];
        for (int i = 0; i < N; i++) {
            L[i][0] = scanner.nextInt(); // Weight
            L[i][1] = scanner.nextInt(); // Value
        }

        // dp[i][j]: max value using first i items with capacity j
        // Size: (N+1) x T
        int[][] dp = new int[N + 1][T];

        // 1. DP Calculation (0/1 Knapsack)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < T; j++) {
                // Item i corresponds to dp[i+1]
                if (j < L[i][0]) {
                    // Cannot include item i
                    dp[i + 1][j] = dp[i][j];
                } else {
                    // Max of (not including item i) or (including item i)
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - L[i][0]] + L[i][1]);
                }
            }
        }

        // 2. Backtracking to find used items
        List<Integer> used = new ArrayList<>();
        int B = dp[N][T - 1]; // Target value
        int j = T - 1;
        
        // We need a boolean array or set to track used indices efficiently
        boolean[] isUsed = new boolean[N];

        for (int i = N - 1; i >= 0; i--) {
            // Check if the current optimal value B is achievable without item i
            // dp[i][j] is the max value using first i items (0 to i-1) with capacity j
            if (B == dp[i][j]) {
                // Item i was not necessary for the optimal solution found so far
                continue;
            }
            
            // Item i must have been used
            B -= L[i][1];
            used.add(i);
            isUsed[i] = true;
            j -= L[i][0];
        }
        
        // 3. Final Calculation
        int ans = dp[N][T - 1];
        int c = 0;
        
        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                // Find max value among unused items
                c = Math.max(c, L[i][1]);
            }
        }
        
        System.out.println(ans + c);
        
        scanner.close();
    }
}
