import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class s977408144 {

    // Global variables from Python
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static int mod = 1000000007;
    static long inf = 10000000000000000000L; // 10^20

    // Helper functions (mimicking Python functions)

    // Note: These functions print directly, mimicking Python's print behavior.
    static void yn(boolean b) {
        if (b) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    static void Yn(boolean b) {
        if (b) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static void YN(boolean b) {
        if (b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // Union-Find Class
    static class UnionFind {
        private int n;
        private int[] P;
        private int[] rank;

        public UnionFind(int n) {
            this.n = n;
            P = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                P[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (x != P[x]) {
                P[x] = find(P[x]);
            }
            return P[x];
        }

        public boolean same(int x, int y) {
            return find(x) == find(y);
        }

        public void link(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    P[rootX] = rootY;
                } else if (rank[rootY] < rank[rootX]) {
                    P[rootY] = rootX;
                } else {
                    P[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }

        public void unite(int x, int y) {
            link(x, y);
        }

        public int size() {
            // Find the number of distinct sets
            int S = 0;
            for (int a = 0; a < n; a++) {
                if (P[a] == a) { // Only count roots
                    S++;
                }
            }
            // The Python implementation used a set of find results, which is more robust if P array is not fully compressed.
            // Let's stick to the Python logic for size calculation:
            /*
            Set<Integer> S = new HashSet<>();
            for (int a = 0; a < n; a++) {
                S.add(find(a));
            }
            return S.size();
            */
            // Since the Python implementation relies on the structure of P, let's re-implement size based on finding roots:
            
            // Re-calculating size based on finding the actual roots (which is what the Python code implies)
            // We must ensure all paths are compressed first, which find() does.
            
            // A simpler way for size in DSU is counting the number of elements whose parent is themselves (roots).
            // However, the Python code explicitly checks the set of roots:
            
            java.util.Set<Integer> roots = new java.util.HashSet<>();
            for (int a = 0; a < n; a++) {
                roots.add(find(a));
            }
            return roots.size();
        }
    }

    // Mathematical functions
    static boolean isPower(long a, long b) {
        if (b == 0) return a == 1;
        long now = 1;
        for (int i = 0; i < b; i++) {
            // Check for overflow if necessary, but assuming inputs fit standard long range for this context
            now *= a;
        }
        return now == a;
    }

    static int[] bin_(long num, int size) {
        int[] A = new int[size];
        for (int a = 0; a < size; a++) {
            // Check the bit at position (size - 1 - a)
            if (((num >> (size - 1 - a)) & 1) == 1) {
                A[a] = 1;
            } else {
                A[a] = 0;