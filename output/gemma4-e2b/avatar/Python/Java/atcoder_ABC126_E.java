import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class atcoder_ABC126_E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N and M
        String line = br.readLine();
        if (line == null) return;
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Initialize adjacency list
        List<List<Integer>> edge = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            edge.add(new ArrayList<>());
        }

        // Read M edges
        for (int i = 0; i < M; i++) {
            String edgeLine = br.readLine();
            if (edgeLine == null) break;
            StringTokenizer stEdge = new StringTokenizer(edgeLine);
            
            // X, Y, Z are read, but only X and Y are used for graph construction
            int X = Integer.parseInt(stEdge.nextToken());
            int Y = Integer.parseInt(stEdge.nextToken());
            // Z is ignored as it's not used in the graph structure
            
            // Convert 1-based indexing to 0-based indexing
            int u = X - 1;
            int v = Y - 1;
            
            // Add undirected edge
            edge.get(u).add(v);
            edge.get(v).add(u);
        }

        boolean[] used = new boolean[N];
        int ans = 0;

        // Find connected components using BFS
        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                ans++;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                used[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    
                    for (int nextnode : edge.get(node)) {
                        if (!used[nextnode]) {
                            used[nextnode] = true;
                            queue.add(nextnode);
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}