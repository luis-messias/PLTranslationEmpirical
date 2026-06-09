import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class atcoder_AGC033_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read h and w
        if (!scanner.hasNextInt()) {
            return;
        }
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        
        // Consume the rest of the line after reading w
        scanner.nextLine(); 

        // Initialize the graph array
        double[][] graph = new double[h][w];

        // Read the graph data
        for (int i = 0; i < h; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < w; j++) {
                char c = line.charAt(j);
                if (c == '#') {
                    graph[i][j] = 0.0;
                } else {
                    graph[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }

        // Pass 1: Left to Right (x=0 to w-2)
        for (int x = 0; x < w - 1; x++) {
            for (int y = 0; y < h; y++) {
                // graph[y][x+1] = min(graph[y][x] + 1, graph[y][x+1])
                double newCost = Math.min(graph[y][x] + 1.0, graph[y][x+1]);
                graph[y][x+1] = newCost;
            }
        }

        // Pass 2: Right to Left (x=w-1 down to 1)
        for (int x = w - 1; x > 0; x--) {
            for (int y = 0; y < h; y++) {
                // graph[y][x-1] = min(graph[y][x] + 1, graph[y][x-1])
                double newCost = Math.min(graph[y][x] + 1.0, graph[y][x-1]);
                graph[y][x-1] = newCost;
            }
        }

        // Pass 3: Top to Bottom (y=0 to h-2)
        for (int y = 0; y < h - 1; y++) {
            for (int x = 0; x < w; x++) {
                // graph[y+1][x] = min(graph[y][x] + 1, graph[y+1][x])
                double newCost = Math.min(graph[y][x] + 1.0, graph[y+1][x]);
                graph[y+1][x] = newCost;
            }
        }

        // Pass 4: Bottom to Top (y=h-1 down to 1)
        for (int y = h - 1; y > 0; y--) {
            for (int x = 0; x < w; x++) {
                // graph[y-1][x] = min(graph[y][x] + 1, graph[y-1][x])
                double newCost = Math.min(graph[y][x] + 1.0, graph[y-1][x]);
                graph[y-1][x] = newCost;
            }
        }

        // Find the maximum value in the graph
        double maxCost = 0.0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (graph[i][j] > maxCost) {
                    maxCost = graph[i][j];
                }
            }
        }

        // Print the result as an integer
        System.out.println((int) Math.round(maxCost));
    }
}
