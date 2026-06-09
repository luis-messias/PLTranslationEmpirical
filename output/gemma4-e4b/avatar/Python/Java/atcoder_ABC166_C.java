import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC166_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read N and M
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 2. Read heights (h)
        // Using 1-based indexing for nodes 1 to N
        int[] heights = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            heights[i] = scanner.nextInt();
        }

        // 3. Initialize Adjacency List (path)
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        // 4. Read Edges (M times)
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            // Undirected graph
            adj[a].add(b);
            adj[b].add(a);
        }

        scanner.close();

        // 5. Counting nodes (c)
        int count = 0;
        
        // Iterate through all nodes i from 1 to N
        for (int i = 1; i <= n; i++) {
            boolean isStrictlyTallerThanAllNeighbors = true;
            
            // Check all neighbors j of node i
            for (int j : adj[i]) {
                // Condition check: If height[i] <= height[j] for any neighbor j
                if (heights[i] <= heights[j]) {
                    isStrictlyTallerThanAllNeighbors = false;
                    break;
                }
            }
            
            // If the node is strictly taller than all its neighbors, increment count
            if (isStrictlyTallerThanAllNeighbors) {
                count++;
            }
        }

        System.out.println(count);
    }
}