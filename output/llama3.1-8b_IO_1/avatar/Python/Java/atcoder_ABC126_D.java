import java.util.Scanner;
import java.util.Set;

public class atcoder_ABC126_D {
    static class Node {
        int val;
        boolean color;
        Node[] a = new Node[100];

        public Node() {}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            nodes[u - 1].val = u;
            nodes[v - 1].val = v;
            Node node1 = nodes[u - 1];
            Node node2 = nodes[v - 1];
            node1.a[w] = node2;
            node2.a[w] = node1;
        }
        Node root = nodes[0];
        root.color = true;
        Set<Node> nodeSet = java.util.Collections.newSetFromMap(new java.util.HashMap<>());
        traverse(root, 0);
        for (int i = 0; i < n; i++) {
            if (nodes[i].color) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    static void traverse(Node node, int distance) {
        if (nodeSet.contains(node)) return;
        nodeSet.add(node);
        for (Node adjNode : node.a) {
            if ((distance + adjNode.val) % 2 == 0) {
                adjNode.color = root.color;
            } else {
                adjNode.color = !root.color;
            }
            traverse(adjNode, distance + adjNode.val);
        }
    }

    static Node root;
}
