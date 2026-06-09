import java.util.*;
import java.io.*;

public class s908812767 {

    // Helper class for adjacency list entries: (neighbor, weight)
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Adjacency list: adj[i] stores list of edges connected to vertex i
    static List<Edge>[] adj;
    // Color array: -1 (uncolored), 0, or 1
    static int[] color;
    static int N;

    /**
     * Performs DFS and checks for coloring consistency based on edge weights.
     * @param u The current vertex.
     * @return true if coloring is consistent, false otherwise.
     */
    static boolean dfs(int u) {
        for (Edge edge : adj[u]) {
            int v = edge.to;
            int w = edge.weight;

            if (w % 2 == 0) {
                // Even weight: u and v must have the same color
                if (color[v] == -1) {
                    color[v] = color[u];
                } else if (color[v] != color[u]) {
                    return false; // Conflict
                }
                // If color[v] == color[u], it's consistent, do nothing.
            } else {
                // Odd weight: u and v must have different colors
                if (color[v] == -1) {
                    // Assign opposite color
                    color[v] = 1 - color[u];
                } else if (color[v] == color[u]) {
                    return false; // Conflict
                }
                // If color[v] != color[u], it's consistent, do nothing.
            }

            // Recurse
            if (!dfs(v)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            // Handle empty input case if necessary, though problem constraints imply N exists
            return;
        }
        
        N = scanner.nextInt();

        // Initialize adjacency list and color array (1-indexed)
        adj = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        color = new int[N + 1];
        Arrays.fill(color, -1);

        // Read N-1 edges
        for (int i = 0; i < N - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();

            // Build graph (undirected)
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }
        
        scanner.close();

        boolean possible = true;
        
        // Iterate through all vertices to handle disconnected components
        for (int i = 1; i <= N; i++) {
            if (color[i] == -1) {
                // Start a new component coloring
                color[i] = 0; // Arbitrarily assign color 0 to the starting node
                
                if (!dfs(i)) {
                    possible = false;
                    break;
                }
            }
        }

        if (!possible) {
            System.out.println("No");
        } else {
            // Print the resulting coloring
            for (int i = 1; i <= N; i++) {
                System.out.print(color[i] + (i == N ? "" : " "));
            }
            System.out.println();
        }
    }
}