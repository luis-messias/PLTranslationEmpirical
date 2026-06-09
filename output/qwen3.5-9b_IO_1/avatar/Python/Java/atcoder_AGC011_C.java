import java.util.*;
import java.io.*;

public class atcoder_AGC011_C {
    static int n, m;
    static int[] vis;
    static ArrayList<Integer>[] g;
    static int ci = 0, cb = 0, cc = 0;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        vis = new int[n + 1];
        g = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g[u].add(v);
            g[v].add(u);
        }
        
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                if (g[i].isEmpty()) {
                    ci++;
                } else {
                    if (dfs(i)) {
                        cb++;
                    } else {
                        cc++;
                    }
                }
            }
        }
        
        System.out.println(ci * ci + 2 * ci * (n - ci) + cc * cc + 2 * cb * cc + 2 * cb * cb);
    }
    
    static boolean dfs(int x) {
        Queue<int[]> stk = new LinkedList<>();
        stk.offer(new int[]{x, 1});
        boolean flag = true;
        
        while (!stk.isEmpty()) {
            int[] pair = stk.poll();
            int u = pair[0];
            int col = pair[1];
            
            if (vis[u] != 0) {
                flag &= (vis[u] == col);
                continue;
            }
            vis[u] = col;
            for (int v : g[u]) {
                stk.offer(new int[]{v, 3 - col});
            }
        }
        return flag;
    }
}
