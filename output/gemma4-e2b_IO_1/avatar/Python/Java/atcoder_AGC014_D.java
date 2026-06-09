import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class atcoder_AGC014_D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N
        int N = Integer.parseInt(br.readLine());

        // Initialize adjacency list (1-based indexing)
        List<List<Integer>> adj = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        // Read N-1 edges
        for (int i = 0; i < N - 1; i++) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // BFS setup
        Deque<Integer> que = new ArrayDeque<>();
        que.add(1);
        
        // seen[i] = 1 if visited, 0 otherwise
        int[] seen = new int[N + 1];
        seen[1] = 1;
        
        // par[u] = parent of u
        int[] par = new int[N + 1];
        // child_num[v] = number of children of v in the BFS tree
        int[] child_num = new int[N + 1];

        // BFS traversal
        while (!que.isEmpty()) {
            int v = que.poll();
            for (int u : adj.get(v)) {
                if (seen[u] == 0) {
                    seen[u] = 1;
                    par[u] = v;
                    child_num[v]++;
                    que.add(u);
                }
            }
        }

        // Collect nodes with child_num == 0 (leaves in the BFS tree)
        Deque<Integer> seq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (child_num[i] == 0) {
                seq.add(i);
            }
        }
