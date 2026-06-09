import java.io.BufferedReader;
import java.io.InputStreamReader;

public class atcoder_ABC135_D {
    static final int MOD = (int) 1e9 + 7;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int n = S.length();

        if (n == 1) {
            if (S.equals("5") || S.equals("?")) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }

        dp = new int[n][13];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (!S.substring(i, i + 1).equals("?")) {
                    dp[i][(S.charAt(i) - '0') % 13]++;
                } else {
                    for (int j = 0; j < 10; j++) {
                        dp[i][j % 13]++;
                    }
                }
            } else {
                if (!S.substring(i, i + 1).equals("?")) {
                    int k = S.charAt(i) - '0';
                    for (int k2 = 0; k2 < 13; k2++) {
                        dp[i][(k * 10 + k2) % 13] += dp[i - 1][k2];
                    }
                } else {
                    for (int j = 0; j < 10; j++) {
                        for (int k = 0; k < 13; k++) {
                            dp[i][(k * 10 + j) % 13] += dp[i - 1][k];
                        }
                    }
                }
                for (int k = 0; k < 13; k++) {
                    dp[i][k] %= MOD;
                }
            }
        }

        System.out.println(dp[n - 1][5]);
    }
}
