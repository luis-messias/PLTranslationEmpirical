import java.util.Scanner;
import java.lang.Math;

public class s210889193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int N = scanner.nextInt();
        
        // Read action array (N rows, 3 columns)
        int[][] action = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (!scanner.hasNextInt()) {
                    // Handle unexpected end of input if N was read but data is missing
                    scanner.close();
                    return;
                }
                action[i][j] = scanner.nextInt();
            }
        }
        
        // dp[i][j] stores max value up to step i, ending in state j
        int[][] dp = new int[N][3];
        
        // Initialization (i=0)
        for (int i = 0; i < 3; i++) {
            dp[0][i] = action[0][i];
        }
        
        // Transitions (i=1 to N-1)
        for (int i = 1; i < N; i++) {
            // dp[i][0] = max(dp[i-1][1] + action[i][0], dp[i-1][2] + action[i][0])
            dp[i][0] = Math.max(dp[i-1][1] + action[i][0], dp[i-1][2] + action[i][0]);
            
            // dp[i][1] = max(dp[i-1][0] + action[i][1], dp[i-1][2] + action[i][1])
            dp[i][1] = Math.max(dp[i-1][0] + action[i][1], dp[i-1][2] + action[i][1]);
            
            // dp[i][2] = max(dp[i-1][0] + action[i][2], dp[i-1][1] + action[i][2])
            dp[i][2] = Math.max(dp[i-1][0] + action[i][2], dp[i-1][1] + action[i][2]);
        }
        
        // Find max(dp[N-1])
        int