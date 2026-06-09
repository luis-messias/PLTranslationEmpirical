import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s764169243 {

    static class SegmentTree {
        int size;
        int defaultVal;
        int[] seg;

        public SegmentTree(int size, int defaultVal) {
            this.defaultVal = defaultVal;
            // Python: self.size = 2**(size-1).bit_length()
            // This calculates the smallest power of 2 >= size, or slightly adjusted based on Python's implementation context.
            // We calculate the smallest power of 2 >= size.
            this.size = 1;
            while (this.size < size) {
                this.size <<= 1;
            }
            
            // The Python code uses 2*self.size - 1 for array size, implying a full binary tree structure.
            // Let's follow the Python calculation structure closely, assuming 'size' here refers to the input N.
            // If N is the input size, the tree size is often 4*N or 2*next_power_of_2(N).
            
            // Replicating the Python logic for size calculation:
            // self.size = 2**(size-1).bit_length()
            // If size=4, 2^3=8. bit_length=4.
            // If size=5, 2^4=16. bit_length=5.
            
            // Since the Python code uses self.size for array sizing (2*self.size - 1), we must ensure consistency.
            // Let's assume the intent is to find the smallest power of 2 >= N, which is standard for segment trees.
            
            // If we strictly follow the Python calculation:
            // We need to find the smallest power of 2, P, such that P >= size.
            // If size=4, P=4. If size=5, P=8.
            
            // Let's use the standard approach for segment tree size based on the required range, which is usually 2*P.
            // Given the Python code's structure, we will calculate the size based on the required array length 2*P.
            
            // Based on the Python code's initialization:
            // self.size = 2**(size-1).bit_length()
            // self.seg = [default]*(2*self.size-1)
            
            // We calculate P = 2^(ceil(log2(size)))
            int P = 1;
            while (P < size) {
                P <<= 1