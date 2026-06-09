import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class s793709854 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and T
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int T = scanner.nextInt();

        // Read L matrix
        int[][] L = new int[N][2];
        for (int i = 0; i < N; i++) {
            if (scanner.hasNextInt()) {
                L[i][0] = scanner.nextInt(); // Length
                L[i][1] = scanner.nextInt(); // Value
            }
        }

        // DP initialization: dp[i][j] max value using first i items with total length j
        // Size (N+1) x T
        int[][] dp = new int[N + 1][T];

        // DP calculation
        for (int i = 0; i < N; i