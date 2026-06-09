import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class s951169509 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read H and W
        if (!scanner.hasNextInt()) return;
        int H = scanner.nextInt();
        int W = scanner.nextInt();

        // Grid dimensions are (H+2) x (W+2)
        int R = H + 2;
        int C = W + 2;

        // Read the grid G
        char[][] G = new char[R][C];

        for (int i = 0; i < R; i++) {
            if (i == 0 || i == R - 1) {
                for (int j = 0; j < C; j++) {
                    G[i][j] = '#';
                }
            } else {
                // Read the line and surround it with '#'
                String line = scanner.next();
                for (int j = 0; j < C; j++) {
                    G[i][j] = '#';
                }
                // Insert the line content
                for (int j = 0; j < line.length(); j++) {
                    G[i][j + 1] = line.charAt(j);
                }
                for (int j = line.length(); j < C; j++) {
                    G[i][j] = '#';
                }
            }
        }

        long ans = 0;

        // Iterate over all possible starting points (sx, sy)
        for (int sx = 0; sx < C; sx++) {
            for (int sy = 0; sy < R; sy++) {
                if (G[sy][sx] == '.') {
                    // Initialize distance matrix and visited array for this BFS run
                    long[][] dist = new long[R][C];
                    boolean[][] visited = new boolean[R][C];

                    for (int i = 0; i < R; i++) {
                        for (int j = 0; j < C; j++) {
                            dist[i][j] = Long.MIN_VALUE;
                            visited[i][j] = false;
                        }
                    }

                    Deque<int[]> q = new ArrayDeque<>();

                    // Start BFS
                    q.add(new int[]{sx, sy});
                    dist[sy][sx] = 0;
                    visited[sy][sx] = true;

                    while (!q.isEmpty()) {
                        int[] current = q.poll();
                        int x = current[0]; // column index
                        int y = current[1]; // row index

                        // Check neighbors (x+1, x-1, y+1, y-1)
                        int[] dx = {1, -1, 0, 0};
                        int[] dy = {0, 0, 1, -1};

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < C && ny >= 0 && ny < R && G[ny][nx] == '.' && !visited[ny][nx]) {
                                q.add(new int[]{nx, ny});
                                dist[ny][nx] = dist[y][x] + 1;
                                visited[ny][nx] = true;
                            }
                        }
                    }

                    // Update ans with the maximum distance found in this BFS run
                    for (int i = 0; i < R; i++) {
                        for (int j = 0; j < C; j++) {
                            if (dist[i][j] != Long.MIN_VALUE) {
                                ans = Math.max(ans, dist[i][j]);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}