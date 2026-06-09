import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class atcoder_ABC146_D {

    // Helper class to represent an edge (pair of nodes) for use as a HashMap key
    static class Edge {
        int u;
        int v;

        public Edge(int u, int v) {
            // Ensure canonical representation (min, max)
            this.u = Math.min(u, v);
            this.v = Math.max(u, v);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return u == edge.u && v == edge.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v);
        }
    }

    /**
     * Performs BFS and calculates K (max color).
     * @param v Start node.
     * @param N Number of nodes.
     * @param G Adjacency list.
     * @param E Edge weight map.
     * @return K, the maximum color found.
     */
    private static int bfs(int v, int N, List<List<Integer>> G, Map<Edge, Integer> E) {
        int[] visited = new int[N];
        Arrays.fill(visited, 0);
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        // K tracks the maximum color
        int K = -1;
        
        // node2color[i] stores the color assigned to node i
        int[] node2color = new int[N];
        Arrays.fill(node2color, -1);

        queue.add(v);
        visited[v] = 1;

        while (!queue.isEmpty()) {
            int q = queue.poll();
            
            int color = 0;
            
            for (int nex : G.get(q)) {
                if (visited[nex]) {
                    continue;
                }
                
                visited[nex] = 1;
                color++;
                
                // Python logic: if color == node2color[q]: color += 1
                if (color == node2color[q]) {
                    color++;
                }
                
                node2color[nex] = color;
                
                // Update edge weight in E
                Edge edge = new Edge(q, nex);
                E.put(edge, color);
                
                queue.add(nex);
            }
            
            K = Math.max(K, color);
        }
        return K;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N
        String line = br.readLine();
        if (line == null || line.isEmpty()) return;
        int N = Integer.parseInt(line.trim());

        // G: Adjacency list
        List<List<Integer>> G = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            G.add(new ArrayList<>());
        }

        // E: Edge weight map
        Map<Edge, Integer> E = new HashMap<>();

        // Read N-1 edges
        for (int i = 0; i < N - 1; i++) {
            String line = br.readLine();
            if (line == null) break;
            String[] parts = line.trim().split("\\s+");
            if (parts.length < 2) continue;
            
            // Input nodes are 1-indexed, convert to 0-indexed
            int a = Integer.parseInt(parts[0]) - 1;
            int b = Integer.parseInt(parts[1]) - 1;

            // Build graph G
            G.get(a).add(b);
            G.get(b).add(a);

            // Initialize edge weight in E
            Edge edge = new Edge(a, b);
            E.put(edge, 0);
        }

        // Run BFS starting from node 0
        int K = bfs(0, N, G, E);
        
        // Print K
        System.out.println(K);
        
        // Print all values in E
        for (int value : E.values()) {
            System.out.println(value);
        }
    }
}
