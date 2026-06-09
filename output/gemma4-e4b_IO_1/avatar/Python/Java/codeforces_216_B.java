import java.util.*;
import java.io.*;

public class codeforces_216_B {

    // Helper class to return the pair (nodes, edges) from DFS
    static class Pair {
        int nodes;
        int edges;

        public Pair(int nodes, int edges) {
            this.nodes = nodes;
            this.edges = edges;
        }
    }

    /**
     * Reads a line of space-separated integers from standard input.
     * Returns null if EOF is reached or no integers are found.
     * Note: This implementation assumes the input stream provides all necessary numbers
     * for one test case block, mimicking Python's line-by-line reading.
     */
    private static List<Integer> readInts(Scanner scanner) {
        List<Integer> line = new ArrayList<>();
        
        // Attempt to read the first token
        if (!scanner.hasNextInt()) {
            return null;
        }
        
        // Read all available integers until the next line break or EOF is encountered
        // This is a simplification based on typical CP input handling.
        while (scanner.hasNextInt()) {
            line.add(scanner.nextInt());
        }
        
        // Since the Python code reads one line, we must consume the rest of the line 
        // to ensure the next read starts correctly.
        scanner.nextLine(); 
        
        return line;
    }

    /**
     * Performs DFS and calculates (nodes, edges) for the connected component.
     * Replicates the specific (and potentially flawed) edge counting logic from the Python source.
     */
    private static Pair dfs(Map<Integer, Set<Integer>> g, Set<Integer> seen, int i) {
        if (seen.contains(i)) {
            return new Pair(0, 0);
        }
        
        seen.add(i);
        int nodes = 1;
        // Initial edges count: degree of i
        int edges = g.get(i).size();
        
        for (int j : g.get(i)) {
            Pair result = dfs(g, seen, j);
            nodes += result.nodes;
            edges += result.edges;
        }
        return new Pair(nodes, edges);
    }

    /**
     * Solves one test case. Returns true if
