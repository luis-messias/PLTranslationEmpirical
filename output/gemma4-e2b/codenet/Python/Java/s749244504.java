import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class s749244504 {

    // Helper class for graph representation and Dijkstra's algorithm
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Implementation of Dijkstra's algorithm to find shortest paths
    // Finds shortest path from startNode to targetNode in a weighted directed graph
    private static Map<Integer, Integer> dijkstra(int startNode, int targetNode, int numNodes, int[][] adjMatrix) {
        // We are looking for shortest path from i to 1.
        // The Python code calculates d[i] = shortest_path_length(G, i, 1, weight='weight')
        // This implies finding the path from i to 1.
        
        // Since the Python code uses nx.shortest_path_length(G, i, 1, weight='weight'), 
        // it finds the path from i to 1.
        
        // We need to adapt Dijkstra's to find paths *from* a specific source (i) *to* a specific target (1).
        
        // For simplicity and matching the Python intent (which uses a general shortest path function), 
        // we will run Dijkstra's starting from 'startNode' and check the distance to 'targetNode'.
        
        // However, the Python code calculates d[i] = shortest_path_length(G, i, 1, weight='weight').
        // This means the source is i and the destination is 1.
        
        // Let's run Dijkstra's starting from i.
        
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
                if (adjMatrix[u][v] > 0) {
                    int weight = adjMatrix[u][v];