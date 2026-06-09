import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class atcoder_ABC148_F {
    static int mod = (int) (1e9 + 7);
    static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int ta = Integer.parseInt(input[1]) - 1;
        int ao = Integer.parseInt(input[2]) - 1;

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1;
            int b = Integer.parseInt(input[1]) - 1;
            g.get(a).add(b);
            g.get(b).add(a);
        }

        long[] taDist = new long[n];
        long[] aoDist = new long[n];

        dfs(g, taDist, ta, g, n);
        dfs(g, aoDist, ao, g, n);

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (taDist[i] > aoDist[i]) continue;
            res = Math.max(res, (int) aoDist[i]);
        }
        System.out.println(res - 1);
    }

    static void dfs(List<List<Integer>> g, long[] dist, int node, List<List<Integer>> graph, int n) {
        for (int v : g.get(node)) {
            if (dist[v] != 0) continue;
            dist[v] = dist[node] + 1;
            dfs(g, dist, v, graph, n);
        }
    }

    static void dfs2(List<List<Integer>> g, long[] dist, int node, List<List<Integer>> graph, int n) {
        for (int v : g.get(node)) {
            if (dist[v] != 0) continue;
            dist[v] = dist[node] + 1;
            dfs2(g, dist, v, graph, n);
        }
    }

    static void dfs(List<List<Integer>> g, long[] dist, int node, List<List<Integer>> graph, int n) {
        for (int i = 0; i < n; i++) {
            if (dist[i] != 0) continue;
            dfs2(g, dist, i, graph, n);
        }
    }
}
