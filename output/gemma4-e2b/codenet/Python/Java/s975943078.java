import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class s975943078 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N and K
        String line1 = br.readLine();
        if (line1 == null) return;
        StringTokenizer st = new StringTokenizer(line1);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // Read array A
        String line2 = br.readLine();
        if (line2 == null) return;
        StringTokenizer stA = new StringTokenizer(line2);
        
        // A elements are transformed: (a % K) - 1
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(stA.nextToken());
            A[i] = (a % K) - 1;
        }

        // sum_A[i] stores prefix sum up to A[i-1] modulo K. Size N+1.
        int[] sum_A = new int[N + 1];
        sum_A[0] = 0;
        for (int i = 0; i < N; i++) {
            sum_A[i + 1] = (sum_A[i] + A[i]) % K;
        }

        // modK maps prefix sum modulo K to a list of indices where that sum occurs.
        // Indices stored are 1-based (i+1 in Python context).
        HashMap<Integer, List<Integer>> modK = new HashMap<>();
        
        // Initialize with sum_A[0] = 0 at index 0 (Python used index 0)
        modK.put(0, new ArrayList<>(List.of(0)));

        for (int i = 1; i <= N; i++) {
            int currentSum = sum_A[i];
            modK.computeIfAbsent(currentSum, k -> new ArrayList<>()).add(i);
        }
        
        long count = 0;

        for (List<Integer> indices : modK.values()) {
            // Sort the indices for binary search efficiency, although they should already be sorted if inserted sequentially.
            // Since we inserted them sequentially (1, 2, 3, ...), they are sorted.
            
            int lenK = indices.size();
            for (int i = 0; i < lenK; i++) {
                int a = indices.get(i);
                
                // Simulate bisect_left(modK[key], a + K, i, lenK) - i - 1
                // We are looking for the count of elements 'b' in indices such that:
                // a < b <= a + K (or related range based on the Python logic)
                
                // The Python logic uses bisect_left(modK[key], a + K, i, lenK) - i - 1
                // This counts elements b in indices[i:lenK] such that b >= a + K.
                // If we use the standard Java binary search approach:
                
                // We search for the insertion point of (a + K) in the list indices[i...lenK-1].
                // Since we are looking for elements strictly greater than 'a' (implied by the context of the problem, usually related to differences), 
                // and the Python code uses a + K, we search