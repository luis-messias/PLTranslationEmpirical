import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class atcoder_ABC133_E {
    static int mod = (int) (1e9 + 7);
    static List<List<Integer>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(dfs(0, -1, K));
    }

    public static long dfs(int fro, int to, int f) {
        int caseNum = f;
        int colorNum = (f == K ? K - 1 : K - 2);

        for (int u : graph.get(fro)) {
            if (u == to) continue;
            long pat = dfs(u, fro, colorNum);
            if (pat == 0) return 0;
            caseNum = (caseNum * pat) % mod;
            colorNum--;
        }
        return caseNum;
    }
}