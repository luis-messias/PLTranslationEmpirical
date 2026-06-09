import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class atcoder_AGC004_D {

    // Structure to hold the result of DFS: (height_from_leaf, cut_count)
    static class Result {
        int heightFromLeaf;
        long cutCount;

        Result(int h, long c) {
            this.heightFromLeaf = h;
            this.cutCount = c;
        }
    }

    /**
     * DFS function implementation
     * @param links Adjacency list representation of the graph.
     * @param n Number of nodes.
     * @param k Target height constraint.
     * @param v Current node.
     * @param p Parent node.
     * @return Result containing (height_from_leaf, cut_count)
     */
    private static Result dfs(Set<Integer>[] links, int n, int k, int v, int p) {
        int heightFromLeaf = 0;
        long cutCount = 0;

        // Iterate over neighbors u of v
        for (int u : links[v]) {
            if (u == 0) {
                continue;
            }
            
            // Recursive call
            Result res = dfs(links, n, k, u, v);
            int hgt = res.heightFromLeaf;
            long cut = res.cutCount;

            heightFromLeaf = Math.max(heightFromLeaf, hgt);
            cutCount += cut;
        }

        heightFromLeaf += 1;

        // Check the condition involving k and p
        if (p != 0 && heightFromLeaf == k) {
            heightFromLeaf = 0;
            cutCount += 1;
        }

        return new Result(heightFromLeaf, cutCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read all input tokens
        String line = br.readLine();
        if (line == null || line.isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);

        if (!st.hasMoreTokens()) return;
        
        // Read n, k, and the rest of the links into aaa
        ArrayList<Integer> aaaList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            aaaList.add(Integer.parseInt(st.nextToken()));
        }
        
        if (aaaList.size() < 2) return;

        int n = aaaList.get(0);
        int k = aaaList.get(1);
        
        // links = [ set ( ) for _ in range ( n ) ]
        @SuppressWarnings("unchecked")
        Set<Integer>[] links = new HashSet[n];
        for (int i = 0; i < n; i++) {
            links[i] = new HashSet<>();
        }

        // Process links (aaa contains the edges, 1-indexed)
        // The links are (i, a) where i is the node index (0 to n-1) and a is the neighbor index (1 to n)
        for (int i = 2; i < aaaList.size(); i++) {
            int a = aaaList.get(i);
            // Input links are 1-indexed, convert to 0-indexed
            int u = a - 1;
            int v = i - 1; // The index of the current link being processed (0-indexed)
            
            // The Python code iterates over aaa: for i, a in enumerate(aaa): a -= 1; links[a].add(i)
            // This implies aaa[0]
