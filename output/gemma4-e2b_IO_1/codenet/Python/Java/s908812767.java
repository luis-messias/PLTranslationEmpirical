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
            return true;
        }
        
        for (int[] edge : V.get(i)) {
            int v = edge[0];
            int w = edge[1];

            if (color[v] == -1) {
                // Uncolored: assign color based on the rule derived from the edge weight parity
                
                if (w % 2 == 0) {
                    // Even weight: color[v] = color[i]
                    color[v] = color[i];
                } else {
                    // Odd weight: color[v] = 1 - color[i]
                    color[v] = 1 - color[i];
                }
                
                if (!dfs(v)) {
                    return false;
                }
            } else if (color[v] == color[i]) {
                // Conflict: same color, but edge exists
                return false;
            }
            // If color[v] != color[i], it's
