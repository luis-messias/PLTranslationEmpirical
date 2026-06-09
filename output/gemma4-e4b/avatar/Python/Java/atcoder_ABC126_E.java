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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Initialize adjacency list
        List<Integer>[] edge = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edge[i] = new ArrayList<>();
        }

        // Read edges
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // Input nodes are 1-indexed, convert to 0-indexed
            int X = Integer.parseInt(st.nextToken()) - 1;
            int Y = Integer.parseInt(st.nextToken()) - 1;
            // Z (weight) is read but ignored
            int Z = Integer.parseInt(st.nextToken()); 

            edge[X].add(Y);
            edge[Y].add(X);
        }

        boolean[] used = new boolean[N];
        int ans = 0;

        // Iterate through all nodes to find connected components
        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                ans++;
                
                // Start BFS
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                used[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int nextnode : edge[node]) {
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