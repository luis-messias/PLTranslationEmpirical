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

        // Read the graph (grid)
        String line = scanner.nextLine();
        // The Python code reads the grid as a single line of characters.
        // We need to parse this line into a 2D structure.
        // Since the Python code reads input() multiple times, we assume the grid is provided on the next line.
        
        // Re-reading the input structure based on typical competitive programming style:
        // If the input is provided exactly as in the Python snippet, it implies reading H, W, then the grid.
        // Let's assume the grid input is provided on the next line.
        
        // Since the Python code reads input() for the grid structure, we read the grid line.
        // We must handle the case where the grid input might be space-separated or a single string of characters.
        
        // Let's re-read the input based on the structure implied by the Python code:
        // h, w = map(int, input().split())
        // graph = [ [0 if i == '#' else float('inf') for i in list(input())] for _ in range(h) ]
        
        // We need to read the grid line.
        String gridLine = scanner.nextLine();
        
        // Initialize the graph structure
        double[][] graph = new double[h][w];
        
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

        // 1. Horizontal pass (Left to Right)
        for (int x = 0; x < w - 1; x++) {
            for (int y = 0; y < h; y++) {
                // graph[y, x+1] = min(graph[y, x] + 1, graph[y, x+1])
                double current = graph[y][x];
                double neighbor = graph[y][x + 1];
                if (current != Double.POSITIVE_INFINITY) {
                    graph[y][x + 1] = Math.min(neighbor, current + 1);
                }
            }
        }

        // 2. Horizontal pass (Right to Left)
        for (int x = w - 1; x > 0; x--) {
            for (int y = 0; y < h; y++) {
                // graph[y, x-1] = min(graph[y, x] + 1, graph[y, x-1])
                double current = graph[y][x];
                double neighbor = graph[y][x - 1];
                if (current != Double.POSITIVE_INFINITY) {
                    graph[y][x - 1] = Math.min(neighbor, current + 1);
                }
            }
        }

        // 3. Vertical pass (Top to Bottom)
        for (int y = 0; y < h - 1; y++) {
            for (int x = 0; x < w; x++) {
                // graph[y+1, x] = min(graph[y, x] + 1, graph[y+1, x])
                double current = graph[y][x];
                double neighbor = graph[y + 1][x];
                if (current != Double.POSITIVE_INFINITY) {
                    graph[y + 1][x] = Math.min(neighbor, current + 1);
                }
            }
        }

        // 4. Vertical pass (Bottom to Top)
        for (int y = h - 1; y > 0; y--) {
            for (int x = 0; x < w; x++) {
                // graph[y-1, x] = min(graph[y, x] + 1, graph[y-1, x])
                double current = graph[y][x];
                double neighbor = graph[y - 1][x];
                if (current != Double.POSITIVE_INFINITY) {
                    graph[y - 1][x] = Math.min(neighbor, current + 1);
                }
            }
        }

        // Find the maximum value
        double maxDist = 0.0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (graph[i][j] > maxDist) {
                    maxDist = graph[i][j];
                }
            }
        }

        //