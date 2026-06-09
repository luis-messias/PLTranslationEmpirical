import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class atcoder_AGC011_C {

    static int n, m;
    static int[] vis;
    static int ci = 0; // Count of isolated nodes
    static int cb = 0; // Count of bipartite components
    static int cc = 0; // Count of non-bipartite components
    static ArrayList<ArrayList<Integer>> g;

    // DFS function to check bipartiteness and color the graph
    // Returns true if the component is bipartite, false otherwise.
    // Colors used: 0 (unvisited), 1, 2.
    static boolean dfs(int x, int color) {
        vis[x] = color;
        boolean componentBipartite = true;

        // Use a stack/queue for iterative traversal (DFS/BFS)
        Deque<Integer> stack = new LinkedList<>();
        stack.add(x);

        while (!stack.isEmpty()) {
            int u = stack.poll();

            for (int v : g.get(u)) {
                if (vis[v] == 0) {
                    // Assign opposite color
                    if (!dfs(v, 3 - color)) {
                        componentBipartite = false;
                    }
                } else if (vis[v] == color) {
                    // Conflict: neighbor has the same color
                    componentBipartite = false;
                }
            }
        }
        return componentBipartite;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) return;
        n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        m = scanner.nextInt();

        // Initialize structures (1-based indexing)
        vis = new int[n + 1];
        g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
            vis[i] = 0;
        }

        // Read edges
        for (int i = 0; i < m; i++) {
            if (!scanner.hasNextInt()) break;
            int u = scanner.nextInt();
            if (!scanner.hasNextInt()) break;
            int v = scanner.nextInt();
            
            // Build undirected graph
