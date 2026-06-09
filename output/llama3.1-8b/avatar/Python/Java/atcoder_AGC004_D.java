import java.util.*;

public class atcoder_AGC004_D {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] links = new int[n][n];
        for (int i = 0; i < n * (n - 1) / 2; i++) {
            int u = scanner.nextInt() - 1;
            links[u][scanner.nextInt() - 1] = 1;
        }
        dfs(links, n, k);
    }

    public static void dfs(int[][] links, int n, int k) {
        int[] heightFromLeaf = new int[n];
        int[] cutCount = new int[n];

        for (int v = 0; v < n; v++) {
            if (links[v][v] == 1) {
                dfsHelper(links, n, k, v, heightFromLeaf, cutCount);
            }
        }

        int maxCut = Arrays.stream(cutCount).max().getAsInt();
        System.out.println(maxCut + 1);
    }

    public static void dfsHelper(int[][] links, int n, int k, int v, int[] heightFromLeaf, int[] cutCount) {
        if (heightFromLeaf[v] != 0) return;

        for (int u = 0; u < n; u++) {
            if (links[v][u] == 1 && u != v) {
                dfsHelper(links, n, k, u, heightFromLeaf, cutCount);
                heightFromLeaf[v] = Math.max(heightFromLeaf[v], heightFromLeaf[u]);
                cutCount[v] += cutCount[u];
            }
        }

        if (heightFromLeaf[v] == k && v != 0) {
            heightFromLeaf[v] = 0;
            cutCount[v]++;
        }

        heightFromLeaf[v]++;
    }
}