import java.util.*;
import java.io.*;

class Node {
    int val;
    boolean color;
    List<Edge> adj;

    public Node() {
        this.val = 0;
        this.color = false;
        this.adj = new ArrayList<>();
    }
}

class Edge {
    Node target;
    int weight;

    public Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class atcoder_ABC126_D {

    private static Set<Node> nodeSet;
    private static Node root;

    public static void traverse(Node node, int distance) {
        if (nodeSet.contains(node)) {
            return;
        } else {
            nodeSet.add(node);
        }

        for (Edge pair : node.adj) {
            Node adjNode = pair.target;
            int dis = pair.weight;

            // Coloring logic based on distance parity
            if ((distance + dis) % 2 == 0) {
                adjNode.color = root.color;
            } else {
                adjNode.color = !root.color;
            }
            
            traverse(adjNode, distance + dis);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N
        String line = br.readLine();
        if (line == null || line.isEmpty()) return;
        int n = Integer.parseInt(line.trim());

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        // Read N-1 edges
        for (int i = 0; i < n - 1; i++) {
            String[] parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int w = Integer.parseInt(parts[2]);

            // Adjusting for 0-based indexing
            Node node1 = nodes[u - 1];
            Node node2 = nodes[v - 1];

            // Setting val (original 1-based index)
            node1.val = u;
            node2.val = v;

            // Adding edges
            node1.adj.add(new Edge(node2, w));
            node2.adj.add(new Edge(node1, w));
        }

        // Initialization for traversal
        root = nodes[0];
        root.color = true;
        nodeSet = new HashSet<>();

        // Perform traversal
        traverse(root, 0);

        // Output results
        for (int i = 0; i < n; i++) {
            Node node = nodes[i];
            if (node.color) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}