import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class atcoder_ABC145_E {

    static class Item {
        int time;
        int val;

        Item(int time, int val) {
            this.time = time;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N and T from the first line
        String line = br.readLine();
        if (line == null) return;
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // Read N items (Time, Value)
        Item[] items = new Item[N];
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            if (line == null) break;
            StringTokenizer stItem = new StringTokenizer(line);
            int time = Integer.parseInt(stItem.nextToken());
            int val = Integer.parseInt(stItem.nextToken());
            items[i] = new Item(time, val);
        }

        // Sort items based on VAL (time_value.sort(key=itemgetter(VAL)))
        Arrays.sort(items, Comparator.comparingInt(item -> item.val));

        // DP initialization: dp[n][t] = max value using first n items with total time <= t
        // N+1 rows (for items 0 to N) and T+1 columns (for time 0 to T)
        int[][] dp = new int[N + 1][T + 1];

        // Base case: dp[0][t] = 0 for all t
        for (int t = 0; t <= T; t++) {
            dp[0][t] = 0;
        }

        // DP calculation
        for (int n = 1; n <= N; n++) {
            // dp[n][0] = 0
            dp[n][0] = 0;
            
            // Get the current item's properties (using 1-based indexing for items)
            int currentTime = items[n - 1].time;
            int currentValue = items[n - 1].val;

            for (int t = 1; t <= T; t++) {
                // Case 1: Cannot include item n (based on Python logic: if time_value[n][TIME] > t)
                if (currentTime > t) {
                    dp[n][t] = dp[n - 1][t];
                } else {
                    // Case 2: Include item
