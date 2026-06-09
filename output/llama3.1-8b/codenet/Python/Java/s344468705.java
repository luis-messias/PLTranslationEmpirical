import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class s344468705 {
    static final int INF = 1000000000;
    static final long MOD = 1000000007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve(br);
        }
    }

    private static void solve(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -INF);
        for (int i = 0; i < n; i++) {
            int num = -Integer.parseInt(br.readLine());
            if (num >= dp[dp.length - 1]) {
                dp[dp.length - 1] = num;
            } else {
                int idx = Arrays.binarySearch(dp, num);
                if (idx < 0) {
                    idx = -idx - 2;
                }
                dp[idx] = num;
            }
        }
        System.out.println(dp.length - 1);
    }
}