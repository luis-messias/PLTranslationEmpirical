import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.util.stream.Collectors;

public class s977408144 {

    // Global constants
    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static final long MOD = 1_000_000_007L;
    // 10^20 requires BigInteger, but since most calculations use MOD, we use a placeholder large long value.
    static final long INF = 1_000_000_000_000_000_000L; 

    // --- Utility Print Functions ---
    public static void yn(boolean b) {
        if (b) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static void Yn(boolean b) {
        if (b) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void YN(boolean b) {
        if (b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // --- Union Find Class ---
    static class UnionFind {
        int n;
        int[] P;
        int[] rank;

        public UnionFind(int n) {
            this.n = n;
            this.P = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                this.P[i] = i;
                this.rank[i] = 0;
            }
        }

        public int find(int x) {
            if (x != this.P[x]) {
                this.P[x] = find(this.P[x]);
            }
            return this.P[x];
        }

        public boolean same(int x, int y) {
            return this.find(x) == this.find(y);
        }

        public void link(int x, int y) {
            if (this.rank[x] < this.rank[y]) {
                this.P[x] = y;
            } else if (this.rank[x] > this.rank[y]) {
                this.P[y] = x;
            } else {
                this.P[x] = y;
                this.rank[x]++;
                this.rank[y]++;
            }
        }
        
        // Corrected union logic based on standard DSU implementation
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
        
        // Re-implementing DSU structure correctly for safety
        private int[] parent;
        private int[] rank;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        public int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }
        
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else {
                    parent[rootJ] = rootI;
                    if (rank[rootI] == rank[rootJ]) {
                        rank[rootI]++;
                    }
                }
            }
        }
    }


    // Helper class for Disjoint Set Union (DSU) to ensure correctness
    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i
