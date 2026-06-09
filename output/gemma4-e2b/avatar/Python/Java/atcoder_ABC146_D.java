import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class atcoder_ABC146_D {

    // Helper class/structure to represent the edge key (min, max) for the map
    static class EdgeKey {
        int u, v;

        public EdgeKey(int a, int b) {
            this.u = Math.min(a, b);
            this.v = Math.max(a, b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EdgeKey edgeKey = (EdgeKey) o;
            return u == edgeKey.u && v == edgeKey.v;
        }

        @Override
        public int hashCode() {
            return 31 * u + v;
        }
    }

    static int bfs(int v, int N, Deque<Integer>[] G, Map<EdgeKey, Integer> E) {
        int[] visited = new int[N];
        // visited[i] = 0 (unvisited), 1 (visited)
        
        Deque<Integer> queue = new ArrayDeque<>();
        Map<EdgeKey, Integer> node2color = new HashMap<>();
        
        int K = -1;
        
        queue.add(v);
        visited[v] = 1;
        
        // Initialize node2color for the starting node v. 
        // The Python code initializes node2color implicitly when it checks node2color[q].
        // We need a way to store the color assigned to nodes.
        // Since the Python code uses node2color[q] to determine the next color, 
        // we will use a map or array for node colors. Let's use an array for simplicity, 
        // assuming colors are assigned sequentially.
        int[] nodeColor = new int[N];
        nodeColor[v] = 0; // Start node color is 0 (or whatever the first color assignment implies)

        while (!queue.isEmpty()) {
            int q = queue.poll();
            int color = nodeColor[q]; // The color assigned to q
            
            int currentMaxColor = 0;

            for (int nex : G[q]) {
                if (visited[nex] == 0) {
                    visited[nex] = 1;
                    
                    // Calculate the next color based on the logic:
                    // color += 1
                    // if color == node2color[q]: color += 1
                    
                    int nextColor = color + 1;
                    if (nextColor == nodeColor[q]) {
                        nextColor += 1;
                    }
                    
                    nodeColor[nex] = nextColor;
                    
                    // Store edge weight/color
                    EdgeKey key = new EdgeKey(q, nex);
                    E.put(key, nextColor);
                    
                    queue.add(nex);
                    currentMaxColor = Math.max(currentMaxColor, nextColor);
                }
            }
            K = Math.max(K, currentMaxColor);
        }
        
        // The Python code seems to calculate K based on the maximum color assigned.
        // We return K.
        return K;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N
        int N = Integer.parseInt(br.readLine());
        
        // G: Adjacency list (Array of Deques)
        @SuppressWarnings("unchecked")
        Deque<Integer>[] G = new Deque[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayDeque<>();
        }
        
        // E: Edge map (using EdgeKey for pair representation)
        Map<EdgeKey, Integer> E = new HashMap<>();
        
        // Read N-1 edges
        for (int i = 0; i < N - 1; i++) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) continue;
            
            StringTokenizer st = new StringTokenizer(line);
            
            // Input is 1-based, convert to 0-based
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            
            G