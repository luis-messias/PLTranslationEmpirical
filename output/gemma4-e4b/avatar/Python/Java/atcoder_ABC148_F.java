import java.util.*;
import java.io.*;

public class atcoder_ABC148_F {

    static int N;
    static List<Integer>[] g;
    static int[] taDist;
    static int[] aoDist;

    // DFS function for TA
    static void taDfs(int node) {
        for (int v : g[node]) {
            if (taDist[v] == -1) {
                taDist[v] = taDist[node] + 1;
                taDfs(v);
            }
        }
    }

    // DFS function for AO
    static void aoDfs(int node) {
        for (int v : g[node]) {
            if (aoDist[v] == -1) {
                aoDist[v] = aoDist[node] + 1;
                aoDfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int ta = Integer.parseInt(st.nextToken()) - 1;
        int ao = Integer.parseInt(st.nextToken()) - 1;

        g = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            g[u].add(v);
            g[v].add(u);
        }

        taDist = new int[N];
        aoDist = new int[N];

        // Initialize distances to -1 (representing None/unvisited)
        Arrays.fill(taDist, -1);
        Arrays.fill(aoDist, -1);

        taDist[ta] = 0;
        aoDist[ao] = 0;

        // Run DFS traversals
        aoDfs(ao);
        taDfs(ta);

        int res = 0;
        for (int i = 0; i < N; i++) {
            // Python condition: if ta_dist[i] > ao_dist[i] : continue
            if (taDist[i] > aoDist[i]) {
                continue;
            }
            // res = max(res, ao_dist[i])
            res = Math.max(res, aoDist[i]);
        }

        System.out.println(res - 1);
    }
}