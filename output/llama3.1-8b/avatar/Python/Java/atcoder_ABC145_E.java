import java.util.*;
import java.io.*;

public class atcoder_ABC145_E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Pair[] time_value = new Pair[N + 1];
        for (int i = 0; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time_value[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(time_value, 1, N + 1, Comparator.comparingInt(p -> p.val));

        int[][] dp = new int[N + 1][T];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int t = 0; t < T; t++) {
            dp[0][t] = 0;
        }
        for (int n = 1; n <= N; n++) {
            dp[n][0] = 0;
            for (int t = 1; t < T; t++) {
                if (time_value[n].time > t) {
                    dp[n][t] = dp[n - 1][t];
                } else {
                    dp[n][t] = Math.max(dp[n - 1][t], time_value[n].val + dp[n - 1][t - time_value[n].time]);
                }
            }
        }

        int val_acum = time_value[N].val;
        int t = T - 1;
        int max_val = val_acum + dp[N - 1][t];
        for (int n = N - 1; n >= 0; n--) {
            val_acum += time_value[n].val;
            t -= time_value[n + 1].time;
            if (t < 0) break;
            else max_val = Math.max(max_val, val_acum + dp[n - 1][t]);
        }
        System.out.println(max_val);
    }

    static class Pair implements Comparable<Pair> {
        int time;
        int val;

        public Pair(int time, int val) {
            this.time = time;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.val, o.val);
        }
    }
}