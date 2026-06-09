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
        int[] heightFromLeaf = new int[n];
        int[] cutCount = new int[n];
        dfs(links, n, k, 0, 0, heightFromLeaf, cutCount);
        System.out.println(cutCount[0]);
    }

    public static void dfs(int[][] links, int n, int k, int v, int p, int[] heightFromLeaf, int[] cutCount) {
        if (v == 0 && p != 0 && heightFromLeaf[v] == k) {
            heightFromLeaf[v] = 0;
            cutCount[p]++;
        }
        for (int u = 0; u < n; u++) {
            if (links[v][u] == 1 && u != v) {
                dfs(links, n, k, u, v, heightFromLeaf, cutCount);
                heightFromLeaf[v] = Math.max(heightFromLeaf[v], heightFromLeaf[u]);
                cutCount[v] += cutCount[u];
            }
        }
        heightFromLeaf[v]++;
    }
}
