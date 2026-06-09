import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.util.stream.Collectors;

public class s977408144 {

    // Global constants
    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static final long MOD = 1_000_000_007L;
    // 10^20 requires BigInteger, but since most calculations use MOD, we stick to long for general utility, 
    // but we must be careful with inf. Let's use a large long value for practical purposes if BigInteger is overkill.
    // Since the Python code uses int(10**20), which is huge, we'll use a placeholder large long value, 
    // assuming the context doesn't exceed long capacity significantly.
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
            } else if (this.rank[y] < this.rank[x]) {
                this.P[y] = x;
            } else {
                this.P[x] = y;
                this.rank[y]++;
            }
        }

        public void unite(int x, int y) {
            this.link(this.find(x), this.find(y));
        }

        public int size() {
            Set<Integer> s = new HashSet<>();
            for (int a = 0; a < this.n; a++) {
                s.add(find(a));
            }
            return s.size();
        }
    }

    // --- Utility Functions ---

    // Checks if a is a power of b
    public static boolean isPower(long a, long b) {
        if (a == 1) return b == 0 || b == 1; // Edge case handling
        if (b == 0) return a == 1;
        if (b == 1) return a == 1;

        long now = b;
        while (now < a && now > 0) {
            // Check for overflow before multiplication
            if (a / b < now) { 
                now = a + 1; // Force exit if overflow would happen
                break;
            }
            now *= b;
        }
        return now == a;
    }

    // Converts number to binary array representation
    public static int[] bin_(long num, int size) {
        int[] A = new int[size];
        for (int a = 0; a < size; a++) {
            // Check the (size - a - 1)-th bit
            if (((num >> (size - a - 1)) & 1) == 1) {
                A[a] = 1;
            } else {
                A[a] = 0;
            }
        }
        return A;
    }

    // Calculates factorials
    public static long[] get_facs(