import java.util.Scanner;

public class s793709854 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int T = scanner.nextInt();
        int[][] L = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                L[i][j] = scanner.nextInt();
            }
        }

        int[][] dp = new int[N + 1][T + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= T; j++) {
                if (j < L[i % N][0]) {
                    dp[i][j] = dp[(i - 1 + N) % (N + 1)][j];
                } else {
                    dp[i][j] = Math.max(dp[(i - 1 + N) % (N + 1)][j], dp[(i - L[i % N][0] + N) % (N + 1)][j]);
                }
            }
        }

        int[] used = new int[N];
        int B = dp[N][T];
        int j = T;
        for (int i = N - 1; i >= 0; i--) {
            if (B == dp[i % N][j]) {
                continue;
            }
            B -= L[i % N][1];
            used[i % N] = 1;
            j -= L[i % N][0];
        }

        int ans = dp[N][T];
        int c = 0;
        for (int i = 0; i < N; i++) {
            if (used[i] == 1) {
                continue;
            }
            c = Math.max(c, L[i][1]);
        }

        System.out.println(ans + c);
    }
}