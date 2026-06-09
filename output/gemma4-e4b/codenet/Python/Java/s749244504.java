import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class s749244504 {

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Helper class for Dijkstra's Priority Queue
    static class Node implements Comparable<Node> {
        int id;
        int distance;

        public Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    /**
     * Dijkstra's algorithm to find the shortest path from startNode to endNode.
     * @param graph Adjacency list representation of the graph.
     * @param startNode The starting node.
     * @param endNode The target node.
     * @param numNodes Total number of nodes.
     * @return The shortest distance, or Integer.MAX_VALUE if unreachable.
     */
    private static int dijkstra(List<List<Edge>> graph, int startNode, int endNode, int numNodes) {
        int[] dist = new int[numNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNode, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.id;
            int d = current.distance;

            if (d > dist[u]) {
                continue;
            }
            
            if (u == endNode) {
                return d;
            }

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int weight = edge.weight;
                
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        
        return dist[endNode];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. Read h and w
        String line = reader.readLine();
        if (line == null) return;
        String[] parts = line.trim().split("\\s+");
        int h = Integer.parseInt(parts[0]);
        int w = Integer.parseInt(parts[1]);

        // 2. Read C (10x10 weight matrix)
        int[][] C = new int[10][10];
        for (int i = 0; i < 10; i++) {
            line = reader.readLine();
            if (line == null) return;
            String[] rowParts = line.trim().split("\\s+");
            for (int j = 0; j < 10; j++) {
                C[i][j] = Integer.parseInt(rowParts[j]);
            }