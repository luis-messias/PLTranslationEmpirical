import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class atcoder_AGC005_B {

    // DSU structures
    private static int[] parent;
    private static int[] rank;
    private static int[] size;

    // Find operation with path compression
    private static int root(int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = root(parent[i]);
        return parent[i];
    }

    // Union operation (unite)
    private static void unite(int i, int j) {
        int rootI = root(i);
        int rootJ = root(j);

        if (rootI != rootJ) {
            // Union by rank/size
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            } else {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
                if (rank[rootI] == rank[rootJ]) {
                    rank[rootI]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read all tokens from standard input
        List<Integer> tokens = new ArrayList<>();
        while (scanner.hasNextInt()) {
            tokens.add(scanner.nextInt());
        }
        scanner.close();

        if (tokens.isEmpty()) {
            System.out.println(0);
            return;
        }

        // n is the first element, a contains the remaining N elements
        int n = tokens.get(0);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = tokens.get(i + 1);
        }

        // Initialize DSU structures
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
            size[i] = 1;
        }

        // b[t - 1] = i, where a[i] = t. 
        // b stores the original index i for a given value t.
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            int t = a[i];
            // Assuming values in a are 1-indexed and within [1, n]
            b[t - 1] = i;
        }

        long c = 0;

        // Iterate k over indices of b in reverse order (n-1 down to 0)