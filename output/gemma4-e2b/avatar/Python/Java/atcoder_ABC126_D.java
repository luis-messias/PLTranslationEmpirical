import java.util.*;
import java.io.*;

class Node {
    int val;
    Boolean color;
    List<int[]> a; // Stores pairs: [neighbor, weight]

    public Node() {
        this.val = null;
        this.color = null;
        this.a = new ArrayList<>();
    }
}

public class atcoder_ABC126_D {

    private static Node[] nodes;
    private static boolean[] nodeSet;
    private static boolean rootColor;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N
        String line = br.readLine();
        if (line == null) return;
        N = Integer.parseInt(line.trim());

        nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node();
        }

        // Read N-1 edges
        for (int i = 0; i < N - 1; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            if (parts.length < 3) continue;
            
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int w = Integer.parseInt(parts[2]);

            // Adjust to 0-based indexing
            Node node1 = nodes[u - 1];
            Node node2 = nodes[v - 1];

            node1.val = u;
            node2.val = v;
            
            // Add edges (bidirectional)
            node1.a.add(new int[]{v, w});
            node2.a.add(new int[]{u, w});
        }

        // Initialization for traversal
        Node root = nodes[0];
        root.color = true;
        nodeSet = new boolean[N];
        
        // Start traversal
        traverse(root, 0);

        // Output results
        for (int i = 0; i < N; i++) {
            if (nodes[i].color) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static void traverse(Node node, int distance) {
        if (nodeSet[node.val]) {
            return;
        } else {
            nodeSet[node.val] = true;
        }

        for (int[] pair : node.a) {
            int adjNodeIndex = pair[0];
            int dis = pair[1];
            
            // Note: The Python code uses node.a which stores [adjNode, weight].
            // The logic relies on the index mapping correctly. 
            // Since we stored the neighbor index (v-1 or u-1) in the adjacency list, 
            // we need to ensure we are accessing the correct node object.
            
            // In the Python code: adjNode = pair[0] (which is a Node object)
            // We need to retrieve the actual Node object from the array index.
            Node adjNode = nodes[adjNodeIndex - 1]; // Adjust index back to 0-based
            
            if ((distance + dis) % 2 == 0) {
                adjNode.color = rootColor;
            } else {
                adjNode.color = !rootColor;
            }
            
            traverse(adjNode, distance + dis);
        }
    }
}