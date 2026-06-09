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

        for (int x = 1; x < w; x++) {
            for (int i = 0; i < h; i++) {
                if (graph[i][x - 1] == '0') {
                    graph[i][x] = '0';
                } else {
                    graph[i][x] = '*'; // equivalent to infinity in Python
                }
            }
        }

        for (int x = w - 2; x >= 0; x--) {
            for (int i = 0; i < h; i++) {
                if (graph[i][x + 1] == '0') {
                    graph[i][x] = '0';
                } else {
                    graph[i][x] = '*'; // equivalent to infinity in Python
                }
            }
        }

        for (int y = 1; y < h; y++) {
            for (int j = 0; j < w; j++) {
                if (graph[y - 1][j] == '0') {
                    graph[y][j] = '0';
                } else {
                    graph[y][j] = '*'; // equivalent to infinity in Python
                }
            }
        }

        for (int y = h - 2; y >= 0; y--) {
            for (int j = 0; j < w; j++) {
                if (graph[y + 1][j] == '0') {
                    graph[y][j] = '0';
                } else {
                    graph[y][j] = '*'; // equivalent to infinity in Python
                }
            }
        }

        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (graph[i][j] == '0') {
                    max = Math.max(max, 1);
                } else {
                    max = Math.max(max, Integer.parseInt(graph[i][j].toString()));
                }
            }
        }

        System.out.println(max);
    }
}