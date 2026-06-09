import java.util.*;
import java.io.*;

public class atcoder_ABC133_E {

    static ArrayList<Integer>[] graph;
    static long MOD = 1_000_000_007L;
    static int K_factor; // Store K globally or pass it

    /**
     * Performs Depth First Search and calculates the product based on the factor K.
     * @param fro The current node.
     * @param to The parent node (to avoid going back immediately).
     * @param f The initial factor/color count for the current node's calculation.
     * @return The calculated product modulo MOD.
     */
    public static long dfs(int fro, int to, int f) {
        long caseNum = f;
        
        // Calculate the factor for the first child.
        // Python logic: colorNum = K - 1 if f == K else K - 2
        // We use K_factor (which holds the input K) for the comparison.
        int colorNum;
        if (f == K_factor) {
            colorNum = K_factor - 1;
        } else {
            colorNum = K_factor - 2;
        }
        
        for (int u : graph[fro]) {
            if (u == to) {
                continue;
            }
            
            // Recursive call: pass the current colorNum as the factor for the child
            long pat = dfs(u, fro, colorNum);
            
            if (pat == 0) {
                caseNum = 0;
                break;
            }
            
            // Update product: caseNum = caseNum * pat % mod
            caseNum = (caseNum * pat) % MOD;
            
            // Decrement the factor for the next child
            colorNum--;
        }
        return caseNum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        K_factor = K; // Store K for use in DFS
        
        // Initialize graph
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Read edges
        for (int i = 0; i < N - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            // Nodes are 1-indexed in input, 0-indexed internally
            graph[a - 1].add(b - 1);
            graph[b - 1].add(a - 1);
        }
        
        scanner.close();
        
        // Initial call: dfs(0, -1, K)
        long ans = dfs(0, -1, K);
        
        System.out.println(ans);
    }
}
