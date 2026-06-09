import java.util.Scanner;

public class atcoder_AGC033_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);

        char[][] graph = new char[h][w];
        for (int i = 0; i < h; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < w; j++) {
                if (row.charAt(j) == '#') {
                    graph[i][j] = '0';
                } else {
                    graph[i][j] = '*'; // equivalent to infinity in Python
                }
            }
        }

        int[][] dist = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (graph[i][j] == '0') {
                    dist[i][j] = 1;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int x = 1; x < w; x++) {
            for (int i = 0; i < h; i++) {
                dist[i][x] = Math.min(dist[i][x], dist[i][x - 1] + 1);
            }
        }

        for (int x = w - 2; x >= 0; x--) {
            for (int i = 0; i < h; i++) {
                dist[i][x] = Math.min(dist[i][x], dist[i][x + 1] + 1);
            }
        }

        for (int y = 1; y < h; y++) {
            for (int j = 0; j < w; j++) {
                dist[y][j] = Math.min(dist[y][j], dist[y - 1][j] + 1);
            }
        }

        for (int y = h - 2; y >= 0; y--) {
            for (int j = 0; j < w; j++) {
                dist[y][j] = Math.min(dist[y][j], dist[y + 1][j] + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                max = Math.max(max, dist[i][j]);
            }
        }

        System.out.println(max);
    }
}
