import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class atcoder_ABC133_E {

    static List<List<Integer>> graph;
    static long MOD;
    static int K;

    // DFS function translation
    // fro: current node
    // to: target node
    // f: state parameter
    public static long dfs(int fro, int to, int f) {
        long caseNum = f;
        
        // colorNum = K - 1 if f == K else K - 2
        int colorNum = (f == K) ? (K - 1) : (K - 2);

        for (int u : graph.get(fro)) {
            if (u == to) {
                continue;
            }
            
            long pat = dfs(u, fro, colorNum);
            
            if (pat == 0) {
                caseNum = 0;
                break;
            }
            
            caseNum = (caseNum * pat) % MOD;
            colorNum--;
        }
        return caseNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N and K
        String line = br.readLine();
        if (line == null) return;
        StringTokenizer st = new StringTokenizer(line);
        
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // Initialize graph
        graph = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // Read N-1 edges
        for (int i = 0; i < N - 1; i++) {
            line = br.readLine();
            if (line == null) break;
            StringTokenizer stEdge = new StringTokenizer(line);
            
            int a = Integer.parseInt(stEdge.nextToken());
            int b = Integer.parseInt(stEdge.nextToken());
            
            // Graph is undirected
            graph.get(a - 1).add(b - 1);
            graph.get(b - 1).add(a - 1);
        }

        // Set modulo
        MOD = 1000000007L;

        // Start DFS: dfs(0, -1, K)
        // Note: -1 is used as the sentinel for 'to'
        long ans = dfs(0, -1, K);
        
        System.out.println(ans);
    }
}