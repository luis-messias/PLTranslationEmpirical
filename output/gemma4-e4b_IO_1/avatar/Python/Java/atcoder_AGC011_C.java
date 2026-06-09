import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class atcoder_AGC011_C {

    static int[] vis;
    static List<Integer>[] g;
    static int N;

    // Helper class to store node and assigned color
    static class Pair {
        int node;
        int color;

        Pair(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    /**
     * Performs DFS starting from node x, attempting to 2-color the component.
     * @param x The starting node.
     * @return true if the component is bipartite (no conflict found), false otherwise.
     */
    static boolean dfs(int x) {
        // Using Deque as a stack implementation
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(x, 1));
        
        // flag tracks if the component remains bipartite throughout the traversal
        boolean isBipartite = true;

        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            int u = current.node;
            int col = current.color;

            if (vis[u] != 0) {
                // Already visited node
                if (vis[u] != col) {
                    // Conflict found: current color conflicts with stored color
                    isBipartite = false;
                }
                // Continue processing even if a conflict is found
                continue;
            }

            // Visit and color the node
            vis[u] = col;

            // Push neighbors with the opposite color
            for (int v : g[u]) {
                int oppositeColor = 3 - col;
                // We push the neighbor and its required color onto the stack
                stack.push(new Pair(v, oppositeColor));
            }
        }
        return isBipartite;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N and M
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        // Initialization (1-based indexing, size N+1)
        vis = new int[N + 1];
        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        // Read edges and build graph
        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            g[u].add(v);
            g[v].add(u);
        }

        // Counters
        long ci = 0; // Isolated components count
        long cb = 0; // Bipartite component count
        long cc = 0; // Non-bipartite component count

        // Process components
        for (int i = 1; i <= N; i++) {
            if (vis[i] == 0) {
                if (g[i].isEmpty()) {
                    // Isolated node
                    ci++;
                } else {
                    // Process component
                    if (dfs(i)) {
                        cb++;
                    } else {
                        cc++;
                    }
                }
            }
        }

        // Calculate the final result: ci*ci + 2*ci*(n-ci)
