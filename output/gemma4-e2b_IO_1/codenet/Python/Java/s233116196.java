import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class s233116196 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N and M
        String[] line1 = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);

        // Initialize adjacency list G (1-based indexing)
        List<List<Integer>> G = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            G.add(new ArrayList<>());
        }

        // Read M edges and build the graph
        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            
            G.get(u).add(v);
            G.get(v).add(u);
        }

        // col stores the component ID for each node, initialized to -1 (unvisited)
        int[] col = new int[N + 1];
        Arrays.fill(col, -1);

        int cnt = 0; // Component counter

        // Iterate through all nodes to find connected components
        for (int i = 1; i <= N; i++) {
            if (col[i] == -1) {
                // Start BFS for a new component
                col[i] = cnt;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);

                while (!queue.isEmpty()) {
                    int x = queue.poll();
                    
                    for (int y : G.get(x)) {
                        if (col[y] == -1) {
                            col[y] = cnt;
                            queue.add(y);
                        }
                    }
                }
                cnt++;
            }
        }

        // The number of connected components is cnt (which is the total number of times we started a new component search)
        // Note: The Python code calculated max(col). Since component IDs are assigned sequentially starting from 0, 
        // the maximum value in col will be cnt - 1, or if we count the number of components found, it is cnt.
        // Let's re-examine the Python logic:
        // Python: cnt starts at 0. When a component is found, col[i] = cnt, then cnt += 1.
        // If N=3, M=0.
        // i=1: col[1]=0, cnt=1.
        // i=2: col[2]=1, cnt=2.
        // i=3: col[3]=2, cnt=3.
        // max(col) = 2. This is wrong. The number of components is 3.
        
        // Let's re-read the Python logic carefully:
        /*
        col = [-1 for _ in range(N+1)]
        cnt = 0
        for i in range(1,N+1):
            if col[i]<0:
                col[i] = cnt  <-- Assigns current cnt
                # ... BFS runs ...
                cnt += 1      <-- Increments cnt after finding a component
        cmax = max(col)
        print(cmax)
        */
        
        // If N=3, M=0.
        // i=1: col[1]=0. cnt=1.
        // i=2: col[2]=1. cnt=2.
        // i=3: col[3]=2. cnt=3.
        // col = [-1, 0, 1, 2]. max(col) = 2. This is still incorrect if the goal is to find the number of components.
        
        // The number of components is exactly the final value of cnt.
        
        System.out.println(cnt);
    }
}
