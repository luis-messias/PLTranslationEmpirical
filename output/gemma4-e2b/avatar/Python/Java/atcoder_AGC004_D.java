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

    // DFS function implementation
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
        
        // Read the entire line of input
        String line = br.readLine();
        if (line == null || line.isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);

        if (!st.hasMoreTokens()) return;
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // Read the rest of the tokens into aaa
        // We need n + 2 tokens in total (n, k, a1, a2, ..., an)
        // The remaining tokens are the edges/links.
        
        // Since the Python code reads all remaining tokens into aaa, we read them all.
        // We need to handle the case where the input might be on a single line or multiple lines.
        
        // Re-reading input based on Python's behavior: sys.stdin.buffer.read().split() reads everything.
        // Let's assume the input is provided on a single line or we read until EOF.
        
        // If we read the whole line and use StringTokenizer, we need to handle the remaining elements.
        
        // Let's re-read the input stream to match the Python logic precisely, assuming all numbers are provided sequentially.
        
        // Since the Python code reads all remaining tokens into aaa, we need to read them all.
        // We will read the rest of the tokens from the tokenizer.
        
        ArrayList<Integer> aaaList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            aaaList.add(Integer.parseInt(st.nextToken()));
        }
        
        // If the number of elements read doesn't match n, something is wrong with the assumption, 
        // but we proceed based on the structure derived from the Python code.
        
        // links = [ set ( ) for _ in range ( n ) ]
        @SuppressWarnings("unchecked")
        Set<Integer>[]