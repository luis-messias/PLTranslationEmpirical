import java.util.Scanner;
import java.lang.Math;

public class codeforces_607_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        int n = scanner.nextInt();

        // Define the maximum size based on the Python code (1000010)
        final int MAX_SIZE = 1000010;
        
        // l[a] stores b
        int[] l = new int[MAX_SIZE];
        // dp[i] stores the calculated DP value
        int[] dp = new int[MAX_SIZE];

        // Read n pairs (a, b) and populate l
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            l[a] = b;
        }

        // Handle dp[0]
        if (l[0] > 0) {
            dp[0] = 1;
        } else {
            dp[0] = 0;
        }

        int mx = 0;

        // Dynamic Programming calculation
        for (int i = 1; i < MAX_SIZE; i++) {
            if (l[i] == 0) {
                // Case 1: l[i] == 0
                dp[i] = dp[i - 1];
            } else {
                // Case 2: l[i] > 0
                if (l[i] >= i) {
                    // Case 2a: l[i] >= i
                    dp[i] = 1;
                } else {
                    // Case 2b: l[i] < i
                    // dp[i] = dp[i - l[i] - 1] + 1
                    dp[i] = dp[i - l[i] - 1] + 1;
                }
            }

            // Update mx
            if (dp[i] > mx) {
                mx = dp[i];
            }
        }

        // Print N - mx
        System.out.println(n - mx);

        scanner.close();
    }
}