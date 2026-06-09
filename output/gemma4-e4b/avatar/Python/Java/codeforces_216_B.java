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
     * Returns null if EOF is reached.
     */
    private static List<Integer> readInts(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            return null;
        }
        List<Integer> line = new ArrayList<>();
        while (scanner.hasNextInt()) {
            line.add(scanner.nextInt());
            // Check if the next token is not an integer (or if we hit the end of the line/input stream)
            // Since we are reading multiple lines potentially, we rely on the structure of the input.
            // For simplicity, we assume the input format is clean and we read all available integers for one line.
            // However, since the Python code reads line by line, we must handle the input stream carefully.
            // Given the context of competitive programming, we assume the input stream provides all necessary numbers sequentially.
            
            // A robust way to handle this in Java without knowing the exact input structure is difficult.
            // We will assume that reading all available integers until the next expected input block starts is sufficient.
            // For this translation, we will read exactly one line's worth of integers.
            
            // Since the Python code uses `input().split()`, it reads one line.
            // We will read until the next line break or EOF is encountered for the current logical input block.
            
            // To simulate reading one line:
            if (scanner.hasNextLine()) {
                String lineStr = scanner.nextLine().trim();
                if (lineStr.isEmpty()) {
                    return line;
                }
                String[] parts = lineStr.split("\\s+");
                for (String part : parts) {
                    if (!part.isEmpty()) {
                        line.add(Integer.parseInt(part));
                    }
                }
                return line;
            } else {
                return line;
            }
        }
        return line;
    }

    /**
     * Performs DFS and calculates (nodes, edges) for the connected component.
     * NOTE: This implementation replicates the potentially flawed edge counting logic from the Python source.
     */
    private static Pair dfs(Map<Integer, Set<Integer>> g, Set<Integer> seen, int i) {
        if (seen