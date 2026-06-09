import java.util.*;
import java.io.*;

public class codeforces_216_B {
    static int[] readInts() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return new int[0];
        }
        String[] parts = line.trim().split("\\s+");
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i]);
        }
        return result;
    }
    
    static int[] dfs(Map<Integer, Set<Integer>> g, Set<Integer> seen, int i) {
        if (seen.contains(i)) {
            return new int[]{0, 0};
        }
        seen.add(i);
        int nodes = 1;
        int edges = g.get(i).size();
        for (int j : g.get(i)) {
            int[] result = dfs(g, seen, j);
            nodes += result[0];
            edges += result[1];
        }
        return new int[]{nodes, edges};
    }
    
    static boolean solve() throws IOException {
        int[] line0 = readInts();
        if (line0.length == 0) return false;
        int n = line0[0];
        int m = line0[1];
        
        Map<Integer, Set<Integer>> g = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        
        for (int i = 1; i <= n; i++) {
            g.put(i, new HashSet<>());
        }
        
        for (int _ = 0; _ < m; _++) {
            int[] edge = readInts();
            int a = edge[0];
            int b = edge[1];
            g.get(a).add(b);
            g.get(b).add(a);
        }
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!seen.contains(i)) {
                int[] result = dfs(g, seen, i);
                int nodes = result[0];
                int edges = result[1];
                if (nodes > 1 && nodes % 2 == 1 && 2 * nodes == edges) {
                    ans++;
                }
            }
        }
        
        if ((n - ans) % 2 == 1) {
            ans++;
        }
        
        System.out.println(ans);
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        while (solve()) {
            // continue loop
        }
    }
}
