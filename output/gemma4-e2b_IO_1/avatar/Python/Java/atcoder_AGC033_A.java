import java.util.Scanner;
import java.util.Arrays;

public class atcoder_AGC033_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read h and w
        if (!scanner.hasNextInt()) return;
        int h = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int w = scanner.nextInt();
        
        // Consume the rest of the line after reading w, if necessary, before reading the grid line.
        // Since the Python code uses input() twice, we expect the grid line next.
        
        // Read the grid line
        if (!scanner.hasNextLine()) return;
        String gridLine = scanner.nextLine();

        // Initialize the graph structure
        double[][] graph = new double[h][w];
        
        // Step 1: Initialize distances based on '#' locations
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (gridLine.charAt(i * w + j) == '#') {
                    graph[i][j] = 0.0;
                } else {
                    graph[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }

        // --- Relaxation steps (Simulating NumPy operations) ---

        // 1. Horizontal pass (Left to Right: graph[y, x+1] = min(graph[y, x] + 1, graph[y, x+1]))
        for (int x = 0; x < w - 1; x++) {
            for (int y = 0; y < h; y++) {
                double current = graph[y][x];
                double neighbor = graph[y][x + 1];
                
                // Only propagate if the current cell is reachable (not infinity)
                if (current != Double.POSITIVE_INFINITY) {
                    graph[y][x + 1] = Math.min(neighbor, current + 1);
                }
            }
        }

        // 2. Horizontal pass (Right to Left: graph[y, x-1] = min(graph[y, x] + 1, graph[y, x-1]))
        for (int x = w - 1; x > 0; x--) {
            for (int y = 0; y < h; y++) {
                double current = graph[y][x];
                double neighbor = graph[y][x - 1];
                
                if (current != Double.POSITIVE_INFINITY) {
                    graph[y][x - 1] = Math.min(neighbor, current + 1);
                }
            }
        }

        // 3. Vertical pass (Top to Bottom: graph[y+1, x] = min(graph[y, x] + 1, graph[y+1, x]))
        for (int y = 0; y < h - 1; y++) {
            for (int x = 0; x < w; x++) {
                double current = graph[y][x];
                double neighbor = graph[y + 1][x];
                
                if (current != Double.POSITIVE_INFINITY) {
                    graph[y + 1][x] = Math.min(neighbor, current + 1);
                }
            }
        }

        // 4. Vertical pass (Bottom to Top: graph[y-1, x] = min(graph[y, x] + 1, graph[y-1, x]))
        for (int y = h - 1; y > 0; y--) {
            for (int
