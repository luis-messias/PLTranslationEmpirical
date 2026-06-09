import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class atcoder_ABC145_E {

    // Helper class to store item data (Time, Value)
    static class Item {
        int time;
        int value;

        public Item(int time, int value) {
            this.time = time;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N and T
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // time_value array (1-indexed, size N+1)
        // Index 0 is unused, Indices 1 to N store the items.
        Item[] timeValue = new Item[N + 1];
        
        // Read N items
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            timeValue[i] = new Item(time, value);
        }

        // Sort items based on Value (VAL)
        // We sort the items from index 1 to N.
        Arrays.sort(timeValue, 1, N + 1, Comparator.comparingInt(item -> item.value));

        // dp[n][t]: max value using first n items with capacity t
        // Size: (N+1) x (T+1)
        int[][] dp = new int[N + 1][T + 1];

        // Initialization (Java arrays are initialized to 0 by default, which matches the Python logic)
        // dp[0][t] = 0 (0 items)
        // dp[n][0] = 0 (0 capacity)

        // Fill DP table
        for (int n = 1; n <= N; n++) {
            int currentTime = timeValue[n].time;
            int currentValue = timeValue[n].value;

            for (int t = 1; t <= T; t++) {
                // If current item time > capacity t, we must skip it
                if (currentTime > t) {
                    dp[n][t] = dp[n - 1][t];
                } else {
                    // Max of (1. Not including item n, 2. Including item n)
                    dp[n][t] = Math.max(dp[n - 1][t], currentValue + dp[n - 1][t - currentTime]);
                }
            }
        }

        // Final calculation loop (Translating the complex post-processing logic)
        
        // Initial values based on the N-th item (timeValue[N])
        int valAcum = timeValue[N].value;
        int tCurrent = T - 1;
        int maxVal = valAcum + dp[N - 1][tCurrent];

        // Loop backwards from n = N-1 down to 1
        for (int n = N - 1; n >= 1; n--) {
            // Accumulate value of item n
            valAcum += timeValue[n].value;
            
            // Update remaining time capacity t
            // The Python code uses time_value[n+1][TIME] here. 
            // Since n is decreasing, n+1 is the item index that was just processed/used to calculate the previous state.
            int timeUsed = timeValue[n + 1].time;
            tCurrent -= timeUsed;
            
            if (tCurrent < 0) {
                break;
            } else {
                // Calculate potential max value: current accumulated value + max value from previous items (n-1) with remaining time (tCurrent)