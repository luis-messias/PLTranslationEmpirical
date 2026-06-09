import java.util.*;

public class s951169509 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        char[][] G = new char[H + 2][W + 2];
        for (int i = 0; i <= H + 1; i++) {
            if (i == 0 || i == H + 1) {
                String row = "";
                for (int j = 0; j <= W + 1; j++) {
                    row += '#';
                }
                G[i] = row.toCharArray();
            } else {
                String row = scanner.next() + "#";
                for (int j = 0; j <= W + 1 - row.length(); j++) {
                    row += '#';
                }
                G[i] = row.toCharArray();
            }
        }

        int ans = 0;
        for (int sx = 0; sx < W + 2; sx++) {
            for (int sy = 0; sy < H + 2; sy++) {
                if (G[sy][sx] == '.') {
                    int[][] dist = new int[H + 2][W + 2];
                    boolean[][] visited = new boolean[H + 2][W + 2];
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{sx, sy});
                    dist[sy][sx] = 0;
                    visited[sy][sx] = true;

                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        int x = p[0], y = p[1];

                        if (G[y][x + 1] == '.' && !visited[y][x + 1]) {
                            q.add(new int[]{x + 1, y});
                            dist[y][x + 1] = dist[y][x] + 1;
                            visited[y][x + 1] = true;
                        }

                        if (G[y][x - 1] == '.' && !visited[y][x - 1]) {
                            q.add(new int[]{x - 1, y});
                            dist[y][x - 1] = dist[y][x] + 1;
                            visited[y][x - 1] = true;
                        }

                        if (G[y + 1][x] == '.' && !visited[y + 1][x]) {
                            q.add(new int[]{x, y + 1});
                            dist[y + 1][x] = dist[y][x] + 1;
                            visited[y + 1][x] = true;
                        }

                        if (G[y - 1][x] == '.' && !visited[y - 1][x]) {
                            q.add(new int[]{x, y - 1});
                            dist[y - 1][x] = dist[y][x] + 1;
                            visited[y - 1][x] = true;
                        }
                    }

                    for (int i = 0; i <= H + 1; i++) {
                        for (int j = 0; j <= W + 1; j++) {
                            if (i < G.length && j < G[0].length) {
                                ans = Math.max(ans, dist[i][j]);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
