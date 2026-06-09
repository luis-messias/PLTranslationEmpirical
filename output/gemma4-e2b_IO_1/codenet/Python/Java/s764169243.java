import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class s764169243 {

    static class SegmentTree {
        int size;
        int defaultVal;
        int[] seg;

        public SegmentTree(int size, int defaultVal) {
            this.defaultVal = defaultVal;
            
            // Replicating Python logic: self.size = 2**(size-1).bit_length()
            // This finds the smallest power of 2, P, such that P >= size.
            int P = 1;
            while (P < size) {
                P <<= 1;
            }
            this.size = P;
            
            // self.seg = [default]*(2*self.size-1)
            this.seg = new int[2 * this.size - 1];
            Arrays.fill(this.seg, defaultVal);
        }

        // function(max, min, plus, minus, etc...)
        int segfunc(int x, int y) {
            return Math.max(x, y);
        }

        // update(k, x)
        public void update(int k, int x) {
            // k is 0-indexed input index. We map it to the leaf node index.
            int k_leaf = k + this.size - 1;
            this.seg[k_leaf] = x;
            
            // Propagate up
            while (k_leaf > 0) {
                k_leaf = (k_leaf - 1) / 2;
                this.seg[k_leaf] = segfunc(this.seg[2 * k_leaf + 1], this.seg[2 * k_leaf + 2]);
            }
        }

        // query([p,q)のsegfunc)
        public int query(int p, int q) {
            if (q <= p) {
                return this.defaultVal;
            }
            
            // Adjust indices based on Python logic: p += self.size-1; q += self.size-2
            // Note: The Python logic seems to be designed for a specific mapping where the range [0, size-1] maps to indices [size-1, 2*size-2] in the array.
            
            // We use the standard segment tree query logic adapted for the specific structure implied by the Python code.
            
            int l = p + this.size - 1;
            int r = q + this.size - 2;
            
            int ret = this.defaultVal;
            
            while (r > l) {
                if (l % 2 == 0) {
                    ret = segfunc(ret, this.seg[l]);
                    l += 1;
                }
                if (r % 2 == 1) {
                    ret = segfunc(ret, this.
