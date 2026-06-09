import java.util.*;
import java.io.*;

class BIT {
    private int[] tree;
    private int size;

    public BIT(int N) {
        this.size = N;
        this.tree = new int[N + 1];
    }

    // Calculates prefix sum up to index i (1-based)
    private int bitsum(int i) {
        int ret = 0;
        while (i > 0) {
            ret += tree[i];
            i -= (i & -i);
        }
        return ret;
    }

    // Calculates sum in range [l, r] (1-based)
    public int bitsumRange(int l, int r) {
        if (l > r) return 0;
        // Note: Python used self._bitsum(r) - self._bitsum(l) for range [l, r]
        // If bitsum(i) is prefix sum up to i, range [l, r] is sum(r) - sum(l-1)
        return bitsum(r) - bitsum(l - 1);
    }

    // Updates value at index i (1-based) by adding x
    public void bitadd(int i, int x) {
        while (i <= size) {
            tree[i] += x;
            i += (i & -i);
        }
    }
}

public class atcoder_ABC107_D {

    // The check function logic, adapted to be static or part of the main logic flow
    private static boolean check(int X, int n, int m, int[] a) {
        // Python: b = [0] + [ (y >= X) * 2 - 1 for y in a ]
        int[] b = new int[n + 1];
        b[0] = 0;
        
        for (int i = 0; i < n; i++) {
            // Transformation: (y >= X) * 2 - 1
            int val = (a[i] >= X ? 1 : 0) * 2 - 1;
            b[i + 1] = val;
        }
        
        // Python: for i in range(n): b[i + 1] += b[i] (Prefix sum)
        for (int i = 1; i <= n; i++) {
            b[i] += b[i - 1];
        }

        // Python: c = min(b)
        int c = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            if (b[i] < c) {
                c =
