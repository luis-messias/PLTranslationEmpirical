import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class s749244504 {

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Implementation of Dijkstra's algorithm to find shortest paths from a source to all other nodes.
    // We need to find the shortest path from source 'startNode' to target '1'.
    private static Map<Integer, Integer> dijkstra(int startNode, int numNodes, int[][] C) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (int k = 0; k < numNodes; k++) {
            distances.put(k, Integer.MAX_VALUE);
        }
        distances.put(startNode, 0);

        // PriorityQueue stores {distance, node}
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Edge(startNode, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.to;
            int dist = current.weight;

            if (dist > distances.get(u)) {
                continue;
            }

            // Iterate over neighbors v of u
            for (int v = 0; v < numNodes; v++) {
                // Check if there is an edge (u, v) with weight C[u][v] > 0
                // Since C is the adjacency matrix, C[u][v] represents the weight of the edge (u, v).
                if (C[u][v] > 0) {
                    int weight = C[u][v];
                    if (distances.get(u) + weight < distances.get(v)) {
                        distances.put(v, distances.get(u) + weight);
                        pq.add(new Edge(v, distances.get(v)));
                    }
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. Read h and w
        String[] line1 = br.readLine().split(" ");
        int h = Integer.parseInt(line1[0]);
        int w = Integer.parseInt(line1[1]);

        // 2. Read C (10x10 matrix)
        int[][] C = new int[10][10];
        String[] line;
        for (int i = 0; i < 10; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                C[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 3. Read A (h x w matrix)
        int[][] A = new int[h][w];
        for (int i = 0; i < h; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                A[i][j] =
