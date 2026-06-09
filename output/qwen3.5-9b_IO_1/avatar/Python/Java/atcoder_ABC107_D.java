import java.util.*;
import java.io.*;

public class atcoder_ABC107_D {
    static class BIT {
        int size;
        int[] tree;
        
        public BIT(int N) {
            this.size = N;
            this.tree = new int[N + 1];
        }
        
        private int _bitsum(int i) {
            int ret = 0;
            while (i > 0) {
                ret += this.tree[i];
                i ^= i & -i;
            }
            return ret;
        }
        
        public int bitsum(int l, int r) {
            if (r == 0) {
                return this._bitsum(l);
            } else {
                return this._bitsum(r) - this._bitsum(l);
            }
        }
        
        public void bitadd(int i, int x) {
            i++;
            while (i <= this.size) {
                this.tree[i] += x;
                i += i & -i;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n * (n + 1) / 4;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        Set<Integer> set = new HashSet<>();
        for (int x : a) {
            set.add(x);
        }
        set.add(0);
        List<Integer> _a = new ArrayList<>(set);
        Collections.sort(_a);
        
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < _a.size(); i++) {
            d.put(_a.get(i), i);
        }
        
        int[] aMapped = new int[n];
        for (int i = 0; i < n; i++) {
            aMapped[i] = d.get(a[i]);
        }
        
        static boolean check(int X, int[] aMapped, int n, int m) {
            int[] b = new int[n + 1];
            for (int i = 0; i < n; i++) {
                b[i + 1] = (aMapped[i] >= X) ? 1 : -1;
            }
            for (int i = 1; i <= n; i++) {
                b[i] += b[i - 1];
            }
            int c = b[0];
            for (int i = 0; i <= n; i++) {
                b[i] -= c;
            }
            BIT bit = new BIT(Math.max(b[n], 0) + 2);
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                ans += bit.bitsum(i, i);
                bit.bitadd(i, 1);
            }
            return ans >= m;
        }
        
        int low = 0;
        int high = _a.size() - 1;
        
        while (high - low > 1) {
            int mid = (low + high) / 2;
            if (check(_a.get(mid), aMapped, n, m)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        
        System.out.println(_a.get(high));
    }
}
