import java.util.*;
import java.io.*;

public class atcoder_ABC166_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Read N and M
        String[] line1 = br.readLine().split(" ");
        if (line1.length < 2) return;
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        // 2. Define P (p = [1, 2, ..., n])
        // p is implicitly defined by range(1, n+1)

        // 3. Read H
        String[] line2 = br.readLine().split(" ");
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(line2[i]);
        }

        // 4. Build HP mapping (hp[i] = h[i-1] for i=1..n)
        // We use an array for hp for direct indexing, size n+1 (using 1-based indexing for convenience)
        int[] hp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // hp[i] corresponds to h[i-1]
            hp[i] = h[i - 1];
        }

        // 5. Initialize Path (Adjacency List)
        // path[i] stores neighbors of i. Indices 1 to n.
        Map<Integer, List<Integer>> path = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            path.put(i, new ArrayList<>());
        }

        // 6. Process M edges