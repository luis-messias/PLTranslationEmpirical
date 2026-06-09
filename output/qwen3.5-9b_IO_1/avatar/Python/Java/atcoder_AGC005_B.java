import java.util.Scanner;
import java.util.Arrays;

public class atcoder_AGC005_B {
    static int[] par;
    static int[] rank;
    static int[] size;
    
    static int root(int x) {
        return par[x] == x ? x : root(par[x]);
    }
    
    static void unite(int x, int y) {
        x = root(x);
        y = root(y);
        if (x != y) {
            if (rank[x] < rank[y]) {
                par[x] = y;
                size[y] += size[x];
            } else {
                par[y] = x;
                size[x] += size[y];
                if (rank[x] == rank[y]) {
                    rank[x]++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        rank = new int[n];
        Arrays.fill(rank, 1);
        size = new int[n];
        Arrays.fill(size, 1);
        
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[a[i] - 1] = i;
        }
        
        long c = 0;
        for (int k = n - 1; k >= 0; k--) {
            long l = 1;
            long r = 1;
            if (k > 0 && a[k - 1] > a[k]) {
                l += size[root(k - 1)];
                unite(k - 1, k);
            }
            if (k + 1 < n && a[k + 1] > a[k]) {
                r += size[root(k + 1)];
                unite(k + 1, k);
            }
            c += l * r * a[k];
        }
        
        System.out.println(c);
    }
}
