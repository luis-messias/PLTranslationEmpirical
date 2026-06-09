import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class s344468705 {

    // Using a large value for infinity, ensuring it fits in long
    private static final long INF = 1_000_000_000_000_000_000L;
    
    // Helper function equivalent to bisect_right
    // Finds the index where 'target' can be inserted while maintaining sorted order,
    // such that all elements before this index are <= target.
    private static int bisectRight(List<Long> list, long target) {
        int low = 0;
        int high = list.size();
        int result = high;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) > target) {
                result = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static void solve(BufferedReader br) throws IOException {
        // Read N (number of elements in the sequence)
        String line = br.readLine();
        if (line == null || line.isEmpty()) return;
        int n = Integer.parseInt(line.trim());

        // dp stores the smallest tail elements of all active subsequences.
        // Since we are looking for LNDS (Longest Non-Decreasing Subsequence) 
        // of the original sequence, we negate the numbers and find LIS.
        // dp will store the smallest tail of an LIS of length k at index k.
        // We initialize it with a dummy element representing length 0.
        List<Long> dp = new ArrayList<>();
        dp.add(-INF); // Sentinel value

        for (int i = 0; i < n; i++) {
            String numLine = br.readLine();
            if (numLine == null || numLine.isEmpty()) break;
            long numOriginal = Long.parseLong(numLine.trim());
            
            // Negate the number
            long num = -numOriginal;

            // Check if the current number can extend the longest subsequence found so far.
            // dp.get(dp.size() - 1) is the tail of the current longest LIS.
            if (num >= dp.get(dp.size() - 1)) {
                dp.add(num);
            } else {
                // Find the index 'idx' where 'num' should replace an existing tail.
                // bisectRight finds the index of the first element strictly greater than 'num'.
                int idx = bisectRight(dp, num);
                
                // Replace the element at idx, as 'num' allows us to achieve the same 
                // subsequence length but with a smaller (more negative) tail.
                dp.set(idx, num);
            }
        }

        // The length of the LIS is dp.size() - 1 (excluding the sentinel element).
        System.out.println(dp.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // The Python code structure suggests reading N first, and then calling solve() N times.
        // However, the provided Python code structure is slightly confusing:
        // 1. main() reads N.
        // 2. loop runs N times, calling solve().
        // 3. solve()