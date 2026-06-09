import java.util.*;
import java.io.*;

public class codeforces_216_B {

    // Helper function to read a line of space-separated integers
    private static List<Integer> readInts(Scanner scanner) {
        List<Integer> result = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                return result;
            }
            String[] parts = line.split("\\s+");
            for (String part : parts) {
                if (!part.isEmpty()) {
                    result.add(Integer.parseInt(part));
                }
            }
        }
        return result;
    }

    // DFS function to calculate nodes and edges in a component
    // g: adjacency list (1-indexed)
    // seen: set of visited nodes (passed by reference/modified)
    // i: current node
    private static int[] dfs(Map<Integer, Set<Integer>> g, Set<Integer> seen, int i) {
        if (seen.contains(i)) {
            return new int[]{0, 0};
        }
        seen.add(i);
        int nodes = 1;
        
        // Calculate edges based on the structure implied by the Python code
        // The Python code initializes edges = len(g[i]) (degree of i)
        int edges = g.getOrDefault(i, Collections.emptySet()).size();

        for (int j : g.getOrDefault(i, Collections.emptySet())) {
            int[] result = dfs(g, seen, j);
            nodes += result[0];
            edges += result[1];
        }
        return new int[]{nodes, edges};
    }

    public static void solve(Scanner scanner) {
        // Read N and M (first line)
        List<Integer> line0 = readInts(scanner);
        if (line0.isEmpty()) {
            return; // EOF reached or empty line
        }
        if (line0.size() < 2) {
            return;
        }
        int n = line0.get(0);
        int m = line0.get(1);

        // Graph initialization (1-indexed)
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            g.put(i, new HashSet<>());
        }

        // Read M edges
        for (int k = 0; k < m; k++) {
            List<Integer> edge = readInts(scanner);
            if (edge.size() >= 2) {
                int a = edge.get(0);
                int b = edge.get(1);
                // Ensure nodes exist before adding edges (though initialization handles 1..N)
                if (g.containsKey(a) && g.containsKey(b)) {
