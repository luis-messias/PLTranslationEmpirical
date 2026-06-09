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

    // Global variables derived from input
    private static int N; // Size of the array a
    private static long M; // Target sum
    private static int[] A_compressed; // The compressed array 'a'
    private static List<Integer> A_sorted_unique; // The sorted unique values '_a'

    /**
     * Checks if the condition is met for a given threshold X.
     * @param X The threshold value.
     * @return True if the condition is met, False otherwise.
     */
    private static boolean check(int X) {
        // N is the length of A_compressed (
