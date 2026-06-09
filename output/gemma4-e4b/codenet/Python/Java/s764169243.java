import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s764169243 {

    static class SegmentTree {
        private int size;
        private long defaultVal;
        private long[] seg;

        // Constructor
        public SegmentTree(int N, long defaultVal) {
            // Calculate the smallest power of 2 >= N
            this.size = 1;
            while (this.size < N) {
                this.size *= 2;
            }
            
            // The array size needs to be 2 * size - 1 if we use 1-based indexing for internal nodes, 
            // but since the Python implementation uses a structure where leaves start at size-1, 
            // and the total size is 2*size-1, we stick to that structure.
            this.seg = new long[2 * this.size - 1];
            this.defaultVal = defaultVal;
            // Initialization is implicitly handled by Java's default array initialization (0 for long)
        }

        // Segment function: max(x, y)
        private long segfunc(long x, long y) {
            return Math.max(x, y);
        }

        // Update: Sets value at index k to x
        public void update(int k, long x) {
            // k is 0-based index in the original array
            k += this.size - 1;
            this.seg[k] = x;
            
            while (k > 0) {
                k = (k - 1) / 2;
                // Left child: 2*k + 1, Right child: 2*k + 2
                this.seg[k] = segfunc(this.seg[2 * k + 1], this.seg[2 * k + 2]);
            }
        }

        // Query: Returns the segfunc over range [p, q)
        public long query(int p, int q) {
            if (q <= p) {
                return this.defaultVal;
            }
            
            // Adjust indices for the segment tree structure
            p += this.size - 1;
            q += this.size - 2;
            
            long ret = this.defaultVal;
            
            while (q - p > 1) {
                // If p is a left child (p is even index in 0-based array, but here we check bit 0)
                if ((p & 1) == 0) {
                    ret = segfunc(ret, this.seg[p]);
                }
                // If q is a right child (q is odd index in 0-based array, but here we check bit 0)
                if ((q & 1) == 1) {
                    ret = segfunc(ret, this.seg[q]);
                    q--;
                }
                p /= 2;
                q = (q - 1) / 2;
            }
            
            // Final combination step
            ret = segfunc(ret, this.seg[p]);
            ret = segfunc(ret, this.seg[q]);
            return ret;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N
        String lineN = br.readLine();
        if (lineN == null || lineN.isEmpty()) return;
        int N = Integer.parseInt(lineN.trim());

        // Read array A
        String lineA = br.readLine();
        if (lineA == null || lineA.isEmpty()) return;
        StringTokenizer st = new StringTokenizer(lineA);
        
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // ans stores the product contributions. Use long.
        long[] ans = new long[N];
        Arrays.fill(ans, 1);

        // --- Left Segment Tree Pass ---
        // left_seg tracks the maximum index encountered so far for a given value.
        // We use 0 as the default value for max query, since indices are positive.
        SegmentTree leftSeg = new SegmentTree(N, 0);
        
        for (int i = 0; i < N; i++) {
            int num = a[i];
            // Query range [0, num)
            // The query result is the maximum index j < num that has appeared before i.
            long max_j = leftSeg.query(0, num);
            
            // Calculation: ans[num-1] *= (i + 1) - max_j
            ans[num - 1] *= (i + 1) - max_j;
            
            // Update: Store current index i+1 at position num-1
            left