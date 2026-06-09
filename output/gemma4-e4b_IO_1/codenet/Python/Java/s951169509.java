import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Queue;

public class s951169509 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            System.out.println(0);
            return;
        }
        
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        
        // Grid dimensions are H+2 rows and W+2 columns
        int R = H + 2;
        int C = W + 2;
        
        char[][] G = new char[R][C];
        
        // Read the grid, handling padding
        for (int i = 0; i < R; i++) {
            if (i == 0 || i == H + 1) {
                // Top and bottom padding rows
                Arrays.fill(G[i], '#');
            } else {
                // Read the actual row and pad it
                String line = scanner.next();
                for (int j = 0; j < W; j++) {
                    G[i][j + 1] = line.charAt(j);
                }
                G[i][W + 1] = '#'; // Right padding
                G[i][0] = '#';    // Left padding
            }
        }
        
        scanner.close();

        int ans = 0;
        
        // Iterate over all possible starting points (sx, sy)
        for (int sy = 0; sy < R; sy++) {
            for (int sx = 0; sx < C; sx++) {
                if (G[sy][sx] == '.') {
                    
                    // Initialize distance and visited arrays for BFS
                    // Using -1 for unvisited, 0 for start, positive for distance
                    int[][] dist = new int[R][C];
                    int[][] visited = new int[R][C];
                    
                    for (int i = 0; i < R; i++) {
                        Arrays.fill(dist[i], -1);
                        Arrays.fill(visited[i], -1);
                    }
                    
                    Queue<int[]> q = new ArrayDeque<>();
                    
                    // Start BFS
                    q.offer(new int[]{sx, sy}); // {x, y}
                    dist[sy][sx] = 0;
                    visited[sy][sx] = 1;
                    
                    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                    
                    while (!q.isEmpty()) {
                        int[] current = q.poll();
                        int x = current[0];
                        int y = current[1];
                        int currentDist = dist[y][x];
                        
                        for (int[] dir : directions) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            
                            // Check bounds
                            if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                               // Check if it's a '.' and unvisited
                               if (G[ny][nx] == '.' && visited[ny][nx] == -1) {
                                   q.offer(new int[]{nx, ny});
                                   dist[ny][nx] = currentDist + 1;
                                   visited[ny][nx] = 1;
                               }
                            }
                        }
                    }
                    
                    // Update overall maximum distance found from this starting point
                    for (int j = 0; j < R; j++) {
                        for (int i = 0; i < C; i++) {
                            // Only update if the cell was reached (dist != -1)
                            if (dist[j][i] != -1) {
                                ans = Math.max(ans, dist[j][i]);
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(ans);
    }
}
