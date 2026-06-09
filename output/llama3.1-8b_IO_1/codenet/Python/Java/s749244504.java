import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s749244504 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = reader.readLine().split(" ");
        int h = Integer.parseInt(line1[0]);
        int w = Integer.parseInt(line1[1]);

        int[][] C = new int[10][10];
        for (int i = 0; i < 10; i++) {
            String[] line2 = reader.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                C[i][j] = Integer.parseInt(line2[j]);
            }
        }

        int[][] A = new int[h][w];
        for (int i = 0; i < h; i++) {
            String[] line3 = reader.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                A[i][j] = Integer.parseInt(line3[j]);
            }
        }

        org.jgrapht.Graph<Integer, DefaultWeightedEdge> G = new org.jgrapht.graph.DefaultDirectedGraph<>(DefaultEdge.class);
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i].length; j++) {
                if (C[i][j] != 0) {
                    G.addVertex(i);
                    G.addVertex(j);
                    G.addEdge(i, j, C[i][j]);
                }
            }
        }

        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            if (i == 1) continue;
            org.jgrapht.alg.DijkstraShortestPath<Integer, DefaultWeightedEdge> dijkstra = new org.jgrapht.alg.DijkstraShortestPath<>(G);
            d.put(i, dijkstra.getPathLength(G, i, 1));
        }

        int s = 0;
        for (int[] row : A) {
            for (int a : row) {
                if (a == -1 || a == 1) continue;
                s += d.getOrDefault(a, 0);
            }
        }
        System.out.println(s);
    }
}
