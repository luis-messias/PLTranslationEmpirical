import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class s908812767 {

    // Adjacency list: Map<Vertex, List<Edge>>
    // Edge: [neighbor, weight]
    private static HashMap<Integer, List<int[]>> V = new HashMap<>();
    // Color: -1 (uncolored), 0, 1
    private static int[] color;
    private static int N;

    /**
     * DFS function to check bipartiteness and color the graph.
     * @param i The current vertex
     * @return true if the component is bipartite, false otherwise.
     */
    private static boolean dfs(int i) {
        // Iterate over neighbors of i
        if (!V.containsKey(i)) {
            return true; // Should not happen if called correctly, but safe check
        }
        
        for (int[] edge : V.get(i)) {
            int v = edge[0];
            int w = edge[1];

            if (color[v] == -1) {
                // Uncolored: assign color based on the rule derived from the edge weight parity
                // The Python logic assigns color[v] = color[i] if w is even, and color[v] = 1 - color[i] if w is odd.
                
                if (w % 2 == 0) {
                    color[v] = color[i];
                } else {
                    color[v] = 1 - color[i];
                }
                
                if (!dfs(v)) {
                    return false;
                }
            } else if (color[v] == color[i]) {
                // Conflict: same color, but edge exists
                return false;
            }
            // If color[v] != color[i], it's consistent, continue.
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N
        String line = br.readLine();
        if (line == null || line.isEmpty()) return;
        N = Integer.parseInt(line.trim());

        // Initialize structures for 1-based indexing (size N+1)
        V.clear();
        color = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            color[i] = -1; // -1 means uncolored
        }

        // Read edges
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // Add edge (u, v, w) to V
            V.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            V.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
        }

        // Iterate through all vertices to find uncolored components
        for (int i = 1; i <= N; i++) {
            if (color[i] == -1) {
                // Start coloring a new component, arbitrarily assign color 0
                color[i] = 0;
                if (!dfs(i)) {
                    System.out.println("No");
                    return;
                }
            }
        }

        // If we reached here, all components were successfully colored
        for (int j = 1; j <= N; j++) {
            System.out.println(color[j]);
        }
    }
}