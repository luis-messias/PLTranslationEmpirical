import java.util.*;
import java.io.*;

class Node {
    int val; // Node ID (1-based in input, stored as 1-based for simplicity in logic, or 0-based internally)
    Boolean color;
    List<int[]> a; // Stores pairs: [neighbor_index, weight]

    public Node() {
        this.val = 0; // Initialize to 0 or handle initialization carefully
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

            // Adjust to 0-based indexing for array access
            int u_idx = u - 1;
            int v_idx = v - 1;

            Node node1 = nodes[u_idx];
            Node node2 = nodes[v_idx];

            // Store node IDs (as per Python logic, though the Python code stored u and v directly)
            node1.val = u;
            node2.val = v;
            
            // Add edges (bidirectional). Store neighbor index and weight.
            node1.a.add(new int[]{v_idx + 1, w}); // Store neighbor index (v_idx + 1 is the 1-based ID v) and weight w
            node2.a.add(new int[]{u_idx + 1, w}); // Store neighbor index (u_idx + 1 is the 1-based ID u) and weight w
        }

        // Initialization for traversal
        Node root = nodes[0];
        root.color = true;
        nodeSet = new boolean[N];
        
        // Start traversal
        traverse(root, 0);

        // Output results
        for (int i = 0; i < N; i++) {
            if (nodes[i].color != null && nodes[i].color) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static void traverse(Node node, int distance) {
        // We use node.val (which stores the 1-based ID) to index nodeSet
        if (nodeSet[node.val
