import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class atcoder_AGC027_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read all space-separated integers from standard input
        List<Integer> data = new ArrayList<>();
        while (scanner.hasNextInt()) {
            data.add(scanner.nextInt());
        }
        
        if (data.size() < 3) {
            // Not enough input to proceed
            return;
        }

        // Unpack N, X, and A
        int N = data.get(0);
        int X = data.get(1);
        
        // A starts from index 2
        List<Integer> A = data.subList(2, data.size());
        
        // 1. Calculate S (cumulative sum of A)
        // S = list(accumulate(A))
        List<Integer> S = new ArrayList<>();
        int currentSum = 0;
        for (int a : A) {
            currentSum += a;
            S.add(currentSum);
        }
        
        // S now has length M = N - 2
        int M = S.size();
        
        // 2. Initialize ans to infinity
        double ans = Double.POSITIVE_INFINITY;
        
        // 3. Loop through S (k is 1-based index)
        // for k, s in enumerate(S, 1):
        for (int k = 1; k <= M; k++) {
            // s corresponds to S[k-1] in 0-based indexing
            int s = S.get(k - 1);
            
            // Calculate the summation term: 2 * sum(S[j] for j in range(N - 2*k - 1, -1, -k))
            long sumTerm = 0;
            
            // Python range: range(N - 2 * k - 1, -1, -k)
            // Java loop equivalent:
            // Start index: N - 2*k - 1
            // End condition: j >= -1 (loop continues while j >= -1)
            // Step: -k
            
            int start = N - 2 * k - 1;
            
            for (int j = start; j >=