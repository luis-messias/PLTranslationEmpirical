import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Stream;

public class atcoder_AGC035_B {

    // Helper class for the Priority Queue element: (degree, node_index)
    static class Node implements Comparable<Node> {
        int degree;
        int index;

        public Node(int degree, int index) {
            this.degree = degree;
            this.index = index;
        }

        // Min-heap based on degree
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.degree, other.degree);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N and M
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        // Adjacency list using HashSet for O(1) removal
        List<Set<Integer>> edges = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            edges.add(new HashSet<>());
        }

        // Degrees array
        int[] degs = new int[N];
        
        // Parity array
        int[] parity = new int[N];
        
        // Flag array (visited/processed)
        boolean[] flag = new boolean[N];

        // Read edges
        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]) - 1;
            int b = Integer.parseInt(edge[1]) - 1;

            // Build graph
            edges.get(a).add(b);
            edges.get(b).add(a);
            
            // Update degrees
            degs[a]++;
            degs[b]++;
        }

        // Initial check: M must be even
        if (M % 2 != 0) {
            System.out.println(-1);
            return;
        }

        // Priority Queue (Min-Heap)
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(new Node(degs[i], i));
        }

        // Main loop
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.index;
            
            if (flag[u]) {
                continue;
            }
            
            flag[u] = true;
            
            // We need to iterate over a copy of the neighbors set because we modify the graph structure
            // and we need to track the index 'i' for the first neighbor check.
            List<Integer> neighbors = new ArrayList<>(edges.get(u));
            
            for (int i = 0; i < neighbors.size(); i++) {
                int v = neighbors.get(i);

                // 1. Remove u from v's adjacency set
                edges.get(v).remove(u);

                // 2. Edge Processing Logic
                if (parity[u] != 0 && i == 0) {
                    // Case 1: parity[u] != 0 AND first neighbor (i=0)
                    System.out.println((u + 1) + " " + (v + 1));
                    parity[u] = 1 - parity[u];
                } else {
                    // Case 2: Otherwise
                    System.out.println((v + 1) + " " + (u + 1));
                    parity[v] = 1 - parity[v];
                }

                // 3. Update degree of v
                degs[v]--;
                
                // 4. Push updated node v back onto PQ
                pq.add(new Node(degs[v], v));
            }
        }
    }
}