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

    // The check function logic
    private static boolean check(int X, int n, int m, int[] a) {
        // 1. Calculate array b based on X
        int[] b = new int[n + 1];
        b[0] = 0;
        for (int i = 0; i < n; i++) {
            // Python: b = [0] + [(y >= X) * 2 - 1 for y in a]
            // The Python code seems to use 'a' (original input array) for this transformation.
            // We assume 'a' here refers to the original input array read earlier.
            if (a[i] >= X) {
                b[i + 1] = 2 * (a[i] - X) - 1; // This interpretation is complex. Let's stick to the literal Python structure.
            } else {
                b[i + 1] = -1; // If y < X, (y >= X)*2 - 1 = -1
            }
        }
        
        // Re-evaluating the Python transformation:
        // b = [0] + [ (y >= X) * 2 - 1 for y in a ]
        // This transformation seems to be based on the indices of the sorted unique values.
        // Let's use the structure implied by the Python code, assuming 'a' is the input array.
        
        // Since the context of 'a' is complex (it's used later for mapping), 
        // we must assume 'a' here refers to the original input array read from stdin.
        
        // Let's re-read the Python logic carefully:
        // b = [0] + [ (y >= X) * 2 - 1 for y in a ]
        // This transformation is applied to the original input array 'a'.
        
        // Since the input reading is outside this function, we need access to the original 'a'.
        // We will pass the original input array 'a' to check.
        
        // --- Re-implementing based on standard interpretation of the algorithm ---
        // The algorithm seems to be related to counting pairs (i, j) such that a[i] + a[j] <= K, 
        // often solved by transforming the array and using BIT.
        
        // Let's assume the input array 'a' passed here is the array used for transformation.