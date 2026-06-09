import java.util.Scanner;
import java.util.Arrays;

public class s210889193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Read the action matrix (N rows, 3 columns)
        int[][] action = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (scanner.hasNextInt()) {
                    action[i][j] = scanner.nextInt();
                }
            }
        }

        // DP table initialization
        int[][] dp = new int[N][3];

        // Base case (Row 0)
        for (int i = 0; i < 3; i++) {
            dp[0][i] = action[0][i];
        }

        // DP transitions
        for (int i = 1; i < N; i++) {
            // dp[i][0] = max(dp[i-1][1] + action[i][0], dp[i-1][2] + action[i][0])
            dp[i][0] = Math.max(dp[i - 1][1] + action[i][0], dp[i - 1][2] + action[i][0]);
            
            // dp[i][1] = max(dp[i-1][0] + action[i][1], dp[i-1][2] + action[i][1])
            dp[i][1] = Math.max(dp[i - 1][0] + action[i][1], dp[i - 1][2] + action[i][1]);
            
            // dp[i][2] = max(dp[i-1][0] + action[i][2], dp[i-1][1] + action[i][2])
            dp[i][2] = Math.max(dp[i - 1][0] + action[i][2], dp[i - 1][1] + action[i][2]);
        }

        // Find the maximum in the last row
        int maxVal = 0;
        for (int j = 0; j < 3; j++) {
            if (dp[N - 1][j] > maxVal) {
                maxVal = dp[N - 1][j];
            }
        }

        System.out.println(maxVal);
        
        scanner.close();
    }
}