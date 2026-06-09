import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class atcoder_AGC014_D {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N
        String line = br.readLine();
        if (line == null || line.isEmpty()) return;
        int N = Integer.parseInt(line.trim());

        // Initialize adjacency list (1-indexed)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        // Read N-1 edges
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // --- BFS Initialization ---
        
        // Queue for BFS
        Queue<Integer> que = new LinkedList<>();
        que.add(1);

        // seen[i] = 0 (unvisited), 1 (visited)
        int[] seen = new int[N + 1];
        seen[1] = 1;

        // par[i] = parent of i
        int[] par = new int[N + 1];
        Arrays.fill(par, 0);

        // child_num[i] = number of children of i in the BFS tree
        int[] child_num = new int[N + 1];

        // --- BFS Traversal ---
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

        // --- Post-BFS Processing ---

        // Deque for sequence (leaves initially)
        LinkedList<Integer> seq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (child_num[i] == 0) {
                seq.addLast(i);
            }
        }

        while (!seq.isEmpty()) {
            // Pop from the end (like Python's deque.pop())
            int c = seq.removeLast();

            // Unmark c
            seen[c] = 0;

            // Check parent
            int p = par[c];
            if (p != 0) {
                if (seen[p] == 0) {
                    System.out.println("First");
                    return;
                }
                // Unmark parent
                seen[p] = 0;

                // Grandparent check: p's parent
                int gp = par[p];
                if (gp != 0) {
                    // Decrement child count of grandparent
                    child_num[gp]--;
                    
                    // If grandparent's child count reaches 0, add it to sequence
                    if (child_num[gp] == 0) {
                        seq.addLast(gp);
                    }
                }
            }
        }

        // If loop completes
        System.out.println("Second");
    }
}