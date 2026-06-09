import java.util.Scanner;

public class atcoder_AGC033_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        
        int[][] graph = new int[h][w];
        
        for (int i = 0; i < h; i++) {
            String row = sc.next();
            for (int j = 0; j < w; j++) {
                if (row.charAt(j) == '#') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        // Left to right propagation
        for (int x = 0; x < w - 1; x++) {
            for (int y = 0; y < h; y++) {
                if (graph[y][x] != 0) {
                    graph[y][x + 1] = Math.min(graph[y][x + 1], graph[y][x] + 1);
                }
            }
        }
        
        // Right to left propagation
        for (int x = w - 1; x > 0; x--) {
            for (int y = 0; y < h; y++) {
                if (graph[y][x] != 0) {
                    graph[y][x - 1] = Math.min(graph[y][x - 1], graph[y][x] + 1);
                }
            }
        }
        
        // Top to bottom propagation
        for (int y = 0; y < h - 1; y++) {
            for (int x = 0; x < w; x++) {
                if (graph[y][x] != 0) {
                    graph[y + 1][x] = Math.min(graph[y + 1][x], graph[y][x] + 1);
                }
            }
        }
        
        // Bottom to top propagation
        for (int y = h - 1; y > 0; y--) {
            for (int x = 0; x < w; x++) {
                if (graph[y][x] != 0) {
                    graph[y - 1][x] = Math.min(graph[y - 1][x], graph[y][x] + 1);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (graph[i][j] != 0) {
                    max = Math.max(max, graph[i][j]);
                }
            }
        }
        
        System.out.println(max);
    }
}
