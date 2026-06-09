import java.util.*;
import java.io.*;

public class atcoder_ABC148_F {
    static int n, ta, ao;
    static ArrayList<Integer>[] g;
    static int[] ta_dist;
    static int[] ao_dist;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ta = Integer.parseInt(st.nextToken());
        ao = Integer.parseInt(st.nextToken());
        
        ta--;
        ao--;
        
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a - 1].add(b - 1);
            g[b - 1].add(a - 1);
        }
        
        ta_dist = new int[n];
        Arrays.fill(ta_dist, -1);
        ta_dist[ta] = 0;
        
        ao_dist = new int[n];
        Arrays.fill(ao_dist, -1);
        ao_dist[ao] = 0;
        
        ta_dfs(ta);
        ao_dfs(ao);
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (ta_dist[i] > ao_dist[i]) {
                continue;
            }
            res = Math.max(res, ao_dist[i]);
        }
        
        System.out.println(res - 1);
    }
    
    static void ta_dfs(int node) {
        for (int v : g[node]) {
            if (ta_dist[v] != -1) {
                continue;
            }
            ta_dist[v] = ta_dist[node] + 1;
            ta_dfs(v);
        }
    }
    
    static void ao_dfs(int node) {
        for (int v : g[node]) {
            if (ao_dist[v] != -1) {
                continue;
            }
            ao_dist[v] = ao_dist[node] + 1;
            ao_dfs(v);
        }
    }
}
