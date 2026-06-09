import java.util.Scanner;
import java.util.ArrayList;

public class s793709854 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        
        int[][] L = new int[N][2];
        for (int i = 0; i < N; i++) {
            L[i][0] = sc.nextInt();
            L[i][1] = sc.nextInt();
        }
        
        int[][] dp = new int[N + 1][T];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < T; j++) {
                if (j < L[i][0]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - L[i][0]] + L[i][1]);
                }
            }
        }
        
        ArrayList<Integer> used = new ArrayList<>();
        int B = dp[N][T - 1];
        int j = T - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (B == dp[i][j]) {
                continue;
            }
            B -= L[i][1];
            used.add(i);
            j -= L[i][0];
        }
        
        int ans = dp[N][T - 1];
        int c = 0;
        for (int i = 0; i < N; i++) {
            if (used.contains(i)) {
                continue;
            }
            c = Math.max(c, L[i][1]);
        }
        
        System.out.println(ans + c);
    }
}
