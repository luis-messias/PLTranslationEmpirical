import java.util.Scanner;

public class atcoder_ABC129_E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String l = scanner.next();
        int n = l.length();
        long mod = 1000000007L;
        long[][] dp = new long[n + 1][2];
        dp[0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            char c = l.charAt(i);
            if (c == '0') {
                dp[i + 1][0] = (dp[i + 1][0] + dp[i][0]) % mod;
                dp[i + 1][1] = (dp[i + 1][1] + dp[i][1] * 3) % mod;
            } else {
                dp[i + 1][0] = (dp[i + 1][0] + dp[i][0] * 2) % mod;
                dp[i + 1][1] = (dp[i + 1][1] + dp[i][0]) % mod;
                dp[i + 1][1] = (dp[i + 1][1] + dp[i][1] * 3) % mod;
            }
        }
        
        System.out.println((dp[n][0] + dp[n][1]) % mod);
    }
}
