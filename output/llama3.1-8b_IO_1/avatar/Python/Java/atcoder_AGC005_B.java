import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class atcoder_AGC005_B {
    static int[] par, rank, size, b;
    static int n, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        n = Integer.parseInt(str[0]);
        par = new int[n];
        rank = new int[n];
        size = new int[n];
        b = new int[n];

        for (int i = 1; i <= n; i++) {
            par[i - 1] = i;
            rank[i - 1] = 1;
            size[i - 1] = 1;
        }

        String[] strA = br.readLine().split("\\s+");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(strA[i]);
        }

        for (int i = 0; i < n; i++) {
            b[a[i] - 1] = i;
        }

        java.util.Arrays.sort(b);

        for (int k : b) {
            int l = 1, r = 1;
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

    public static int root(int x) {
        if (par[x - 1] == x)
            return x;
        else
            return par[x - 1] = root(par[x - 1]);
    }

    public static boolean same(int x, int y) {
        return root(x) == root(y);
    }

    public static void unite(int... z) {
        int x = root(z[0]), y = root(z[1]);
        if (x != y) {
            if (rank[x - 1] < rank[y - 1]) {
                par[x - 1] = y;
                size[y - 1] += size[x - 1];
            } else {
                par[y - 1] = x;
                size[x - 1] += size[y - 1];
                if (rank[x - 1] == rank[y - 1])
                    rank[x - 1]++;
            }
        }
    }
}
