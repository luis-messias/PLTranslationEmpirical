import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class atcoder_AGC005_B {

    // DSU structure arrays
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
        
        // Read all numbers into array a
        int[] a = new int[st.countTokens()];
        int index = 0;
        while (st.hasMoreTokens()) {
            a[index++] = Integer.parseInt(st.nextToken());
        }
        
        int n = a.length;

        // Initialize DSU structures
        par = new int[n];
        rank = new int[n];
        size = new int[n];
        
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 1;
            size[i] = 1;
        }

        // b maps values to their original indices (used for sorting/mapping)
        // The Python code uses b[t-1] = i where t is the value in a, and i is the index.
        // Since the values in 'a' can be large, we need a mapping structure if we were strictly following the Python logic where 't' is used as an index.
        // However, the Python code seems to use 'a' values to determine indices for 'b'.
        
        // Let's re-examine the Python input reading:
        // n , * a = map ( int , open ( 0 ).read ( ).split ( ) )
        // * par , = range ( n )
        // ...
        // for i , t in enumerate ( a ) : b [ t - 1 ] = i
        
        // This implies 'a' contains the values, and we are mapping values to indices.
        // If 'a' is the input array, the Python code seems to be using the values in 'a' to determine the indices for 'b'.
        
        // Let's assume the standard interpretation for inversion counting:
        // We need to map the values in 'a' to their original positions.
        
        // If the input array 'a' is the array of numbers we are analyzing:
        // a = [a0, a1, a2, ...]
        // We need