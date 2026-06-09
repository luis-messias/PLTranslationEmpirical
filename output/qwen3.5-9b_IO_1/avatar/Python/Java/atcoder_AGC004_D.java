import java.util.*;
import java.io.*;

public class atcoder_AGC004_D {
    static int n, k;
    static List<Set<Integer>> links;
    
    static class Pair {
        int height;
        int cut;
        Pair(int h, int c) {
            height = h;
            cut = c;
        }
    }
    
    static Pair dfs(List<Set<Integer>> links, int n, int k, int v, int p) {
        int heightFromLeaf = 0;
        int cutCount = 0;
        
        for (int u : links.get(v)) {
            if (u == 0) {
                continue;
            }
            Pair result = dfs(links, n, k, u, v);
            heightFromLeaf = Math.max(heightFromLeaf, result.height);
            cutCount += result.cut;
        }
        
        heightFromLeaf += 1;
        
        if (p != 0 && heightFromLeaf == k) {
            heightFromLeaf = 0;
            cutCount += 1;
        }
        
        return new Pair(heightFromLeaf, cutCount);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        links = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            links.add(new HashSet<>());
        }
        
        // Read remaining integers (parent pointers)
        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());
                int i = 0;
                // Count how many integers we've read to determine i
                // Actually we need to track position
            }
        }
        
        // Better approach: read all tokens
        // Reset and read all integers
        br.close();
        
        // Re-implement with proper input reading
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            n = sc.nextInt();
            k = sc.nextInt();
            
            links = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                links.add(new HashSet<>());
            }
            
            for (int i = 0; i < n - 1; i++) {
                if (sc.hasNextInt()) {
                    int a = sc.nextInt();
                    a -= 1;
                    links.get(a).add(i);
                }
            }
            
            Pair result = dfs(links, n, k, 0, 0);
            int ans = result.cut;
            
            if (n > 1 && links.get(0).size() != 1) {
                ans += 1;
            }
            
            System.out.println(ans);
        }
    }
}
