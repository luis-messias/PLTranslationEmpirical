import java.util.Scanner;

public class codeforces_607_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        final int MAX_SIZE = 1000010;
        int[] l = new int[MAX_SIZE];
        int[] dp = new int[MAX_SIZE];

        // Read n pairs and populate l
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) break;
            int a = scanner.nextInt();
            if (!scanner.hasNextInt()) break;
            int b = scanner.nextInt();
            
            // Assuming a is a valid index within bounds based on Python logic
            if (a >= 0 && a < MAX_SIZE) {
                l[a] = b;
            }
        }

        // Handle the initial condition from Python
        if (l[0] > 0) {
            dp[0] = 1;
        }

        int mx = 0;

        // DP calculation
        for (int i = 1; i < MAX_SIZE; i++) {
            if (l[i] == 0) {
                dp[i] = dp[i - 1];
            } else {
                if (l[i] >= i) {
                    dp[i] = 1;
                } else {
                    // Note: The Python code uses l[i] - 1 in the index calculation.
                    // dp[i] = dp[i - l[i] - 1] + 1
                    // We must ensure i - l[i] - 1 is non-negative.
                    int index = i - l[i] - 1;
                    if (index >= 0) {
                        dp[i] = dp[index] + 1;
                    } else {
                        // This case should ideally not happen if the logic is sound, 
                        // but we handle it defensively.
                        dp[i] = 1; 
                    }
                }
            }

            if (dp[i] > mx) {
                mx = dp[i];
            }
        }

        // Print result
        System.out.println(n - mx);
        
        scanner.close();
    }
}
