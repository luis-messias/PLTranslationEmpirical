import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class atcoder_ABC166_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Read N and M
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 2. Read H
        int[] h = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        // 3. Build HP mapping
        // hp[i] will store the value corresponding to node i (1-based indexing).
        // Since p = [1, 2, ..., n] and h is 0-indexed, hp[i] = h[i-1].
        int[] hp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            hp[i] = h[i - 1];
        }

        // 4. Initialize Path (Adjacency List)
        // path[i] stores neighbors of i. Indices 1 to n.
        HashMap<Integer, List<Integer>> path = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            path.put(i, new ArrayList<>());
        }

        // 5. Process M edges
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // Add undirected edge
            path.get(a).add(b);
            path.get(b).add(a);
        }

        // 6. Calculate C
        int c = 0;
        
        // Iterate through all nodes i from 1 to n
        for (int i = 1; i <= n; i++) {
            List<Integer> neighbors = path.get(i);
            
            // Check the condition for node i
            boolean found_j = false;
            for (int j : neighbors) {
                // Check if hp[i] <= hp[j]
                if (hp[i] <= hp[j]) {
                    found_j = true;
                    break;
                }
            }
            
            // If the condition (hp[i] <= hp[j]) was never met for any neighbor j, 
            // it means for all neighbors j, hp[i] > hp[j].
            // The Python logic was:
            // f = 0 (assume false)
            // for j in v: if hp[i] <= hp[j]: f = 1; break
            // if f == 0: c += 1
            
            // This means we increment c if the loop finishes without finding any neighbor j 
            // such that hp[i] <= hp[j].
            
            if (!found_j) {
                c++;
            }
        }

        System.out.println(c);
    }
}
