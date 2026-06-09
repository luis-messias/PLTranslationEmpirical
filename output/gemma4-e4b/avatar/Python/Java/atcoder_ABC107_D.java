import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class BIT {
    private int size;
    private int[] tree;

    public BIT(int N) {
        this.size = N;
        // BIT uses 1-based indexing, so size N needs N+1 array elements
        this.tree = new int[N + 1];
    }

    // Calculates prefix sum up to index i (1-based)
    private int bitsum(int i) {
        int ret = 0;
        while (i > 0) {
            ret += tree[i];
            i -= i & (-i);
        }
        return ret;
    }

    // Calculates range sum from l to r (inclusive, 1-based)
    public int bitsum(int l, int r) {
        if (l > r) return 0;
        return bitsum(r) - bitsum(l - 1);
    }

    // Updates the value at index i (1-based) by adding x
    public void bitadd(int i, int x) {
        // i must be 1-based index
        while (i <= this.size) {
            this.tree[i] += x;
            i += i & (-i);
        }
    }
}

public class atcoder_ABC107_D {

    // Global variables to be accessed by check method
    private static int N;
    private static int M;
    private static int[] A_compressed;
    private static List<Integer> A_sorted_unique;

    /**
     * Checks if the condition is met for a given threshold X.
     * @param X The threshold value.
     * @return True if the condition is met, False otherwise.
     */
    private static boolean check(int X) {
        // 1. Calculate array b
        int[] b = new int[N + 1];
        for (int i = 0; i < N; i++) {
            // Python logic: b[i+1] = (y >= X) * 2 - 1
            // (y >= X) evaluates to 1 if true, 0 if false.
            int indicator = (A_compressed[i] >= X) ? 1 : 0;
            b[i + 1] = indicator * 2 - 1;
        }

        // 2. Calculate prefix sums for b
        for (int i = 1; i <= N; i++) {
            b[i] += b[i - 1];
        }

        // 3. Find minimum value c
        int c = b[0];
        for (int i = 1; i <= N; i++) {
            if (b[i] < c) {
                c = b[i];
            }
        }

        // 4. Create new array b (b[i] = b[i] - c)
        for (int i = 1; i <= N; i++) {
            b[i] -= c;
        }

        // 5. Use BIT
        int maxB = 0;
        for (int i = 1; i <= N; i++) {
            if (b[i] > maxB) {
                maxB = b[i];
            }
        }