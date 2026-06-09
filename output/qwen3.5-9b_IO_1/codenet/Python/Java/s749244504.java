import java.util.*;
import java.io.*;

public class s749244504 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        // Read h, w
        int h = sc.nextInt();
        int w = sc.nextInt();
        
        // Read C (10x10 matrix)
        int[][] C = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                C[i][j] = sc.nextInt();
            }
        }
        
        // Read A (h x w matrix)
        int[][] A = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        
        // Build graph from C - C[i][j] is weight from i to j
        // If C[i][j] == 0, no edge exists
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < 10; j++) {
                if (C[i][j] != 0) {
                    adj.get(i).add(new Edge(j, C[i][j]));
                }
            }
        }
        
        // Dijkstra from node 1
        int[] dist = new int[10];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.id;
            int d = current.dist;
            
            if (d > dist[u]) continue;
            
            for (Edge e : adj.get(u)) {
                if (dist[e.to] > d + e.weight) {
                    dist[e.to] = d + e.weight;
                    pq.add(new Node(e.to, dist[e.to]));
                }
            }
        }
        
        // Calculate sum
        long s = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int a = A[i][j];
                if (a == -1 || a == 1) {
                    continue;
                }
                s += dist[a];
            }
        }
        
        System.out.println(s);
    }
    
    static class Edge {
        int to;
        int weight;
        
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    static class Node implements Comparable<Node> {
        int id;
        int dist;
        
        Node(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
        
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }
}
