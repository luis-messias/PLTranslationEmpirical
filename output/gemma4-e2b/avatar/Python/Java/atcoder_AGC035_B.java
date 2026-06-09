import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class atcoder_AGC035_B {

    static class Edge implements Comparable<Edge> {
        int degree;
        int vertex;

        public Edge(int degree, int vertex) {
            this.degree = degree;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.degree, other.degree);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // edges[i] stores the set of neighbors of vertex i (0-indexed)
        @SuppressWarnings("unchecked")
        Set<Integer>[] edges = new HashSet[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new HashSet<>();
        }

        // degs[i] stores the degree of vertex i
        int[] degs = new int[N];
        // parity[i] stores the parity state for vertex i
        int[] parity = new int[N];
        // flag[i] tracks if vertex i has been processed
        boolean[] flag = new boolean[N];

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // Convert to 0-based indexing
            int u = a - 1;
            int v = b - 1;

            edges[u].add(v);
            edges[v].add(u);
            degs[u]++;
            degs[v]++;
        }

        if (M % 2 != 0) {
            System.out.println(-1);
            return;
        }

        // Priority Queue (Min-Heap) for (degree, vertex)
        PriorityQueue<Edge> Q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            Q.add(new Edge(degs[i], i));
        }

        while (!Q.isEmpty()) {
            Edge current = Q.poll();
            int u = current.vertex;
            int d = current.degree;

            if (flag[u]) {
                continue;
            }
            flag[u] = true;

            // Iterate over neighbors of u
            // We must iterate over a copy or handle removal carefully since we modify the set inside.
            // Since we are iterating over edges[u], we iterate over the neighbors currently in the set.
            
            // Create a list of neighbors to iterate over, as we modify the set during iteration
            ArrayList<Integer> neighbors = new ArrayList<>(edges[u]);

            for (int v : neighbors) {
                // Remove the edge (u, v) from the adjacency sets
                edges[v].remove(u);

                // Parity logic based on the original Python code structure
                if (parity[u] != 0 && (v == neighbors.get(0))) { // i == 0 in Python loop corresponds to the first neighbor found in the iteration order.
                    System.out.println(u + 1 + " " + v + 1);
                    parity[u] = 1 - parity[u];
                } else {
                    System.out.println(v + 1 + " " + u + 1);
                    parity