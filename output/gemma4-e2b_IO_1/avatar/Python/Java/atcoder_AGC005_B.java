import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class atcoder_AGC005_B {

    // DSU structure arrays (must be instance variables or accessible globally)
    private int[] par;
    private int[] rank;
    private int[] size;

    // Find operation with path compression
    private int root(int x) {
        if (par[x] == x) {
            return x;
        }
        par[x] = root(par[x]);
        return par[x];
    }

    // Union operation by rank
    private void unite(int x, int y) {
        int rootX = root(x);
        int rootY = root(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                par[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                par[rootY] = rootX;
                size[rootX] += size[rootY];
                if (rank[rootX] == rank[rootY]) {
                    rank[rootX]++;
                }
            }
        }
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        
        // Read N and the array A
        // The Python code reads N and then *a (the rest of the line).
        // We need to handle reading N and the array A correctly.
        
        // Since the input format is N followed by N elements, we read the whole line.
        // We assume the first token is N, and the rest are A_i.
        
        // Read all tokens into a list first to determine N and A
        String[] tokens = line.split(" ");
        if (tokens.length == 0) return;
        
        // The first token is N
        int n = Integer.parseInt(tokens[0]);
        if (n == 0) {
            System.out.println(0);
            return;
        }
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokens[i + 1]);
        }

        // Initialize DSU structures
        par = new int[n];
        rank = new int[n];
        size = new int[n];
        
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 1;
            size[
