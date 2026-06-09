import java.util.Scanner;

public class atcoder_ABC132_F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long mod = 1000000007L;
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        long[] coef = new long[n];
        int i = 1;
        while (i * i <= n) {
            coef[i - 1] = (n / i) - (n / (i + 1));
            i++;
        }
        
        long sumCoef = 0;
        for (long c : coef) {
            sumCoef += c;
        }
        
        int remaining = n - (int)sumCoef;
        for (int j = 0; j < remaining; j++) {
            coef[j + i - 1] = 1;
        }
        
        int nn = n;
        long[][] dp = new long[k + 1][nn];
        dp[0][0] = 1;
        
        for (int i = 1; i <= k; i++) {
            long tmp = 0;
            for (int j = nn - 1; j >= 0; j--) {
                tmp += dp[i - 1][nn - 1 - j];
                tmp %= mod;
                dp[i][j] = (coef[j] * tmp) % mod;
            }
        }
        
        long result = 0;
        for (int j = 0; j < nn; j++) {
            result += dp[k][j];
            result %= mod;
        }
        
        System.out.println(result);
    }
}
