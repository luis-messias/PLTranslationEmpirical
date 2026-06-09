import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class atcoder_ABC105_D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N and M
        String line1 = br.readLine();
        if (line1 == null) return;
        StringTokenizer st1 = new StringTokenizer(line1);
        
        // N and M are read, but N is implicitly determined by the length of A.
        // We only need M for the calculation.
        long M = Long.parseLong(st1.nextToken());

        // Read array A
        String line2 = br.readLine();
        if (line2 == null) return;
        StringTokenizer st2 = new StringTokenizer(line2);

        // A contains the elements a_1, a_2, ..., a_N
        long[] A = new long[st2.countTokens()];
        for (int i = 0; i < st2.countTokens(); i++) {
            A[i] = Long.parseLong(st2.nextToken());
        }
        
        // The calculation involves an extended array [0, A_1, A_2, ..., A_N]
        // We calculate the cumulative sum of remainders modulo M.
        
        // We use a HashMap to store remainder counts (equivalent to Counter)
        Map<Long, Long> remainderCounts = new HashMap<>();
        
        long currentSum = 0;
        
        // Start with the initial 0 (A_ext[0] = 0)
        long remainder = 0 % M;
        remainderCounts.put(remainder, remainderCounts.getOrDefault(remainder, 0L) + 1);
        currentSum = remainder; // This is the cumulative sum up to index 0

        // Iterate through A to calculate cumulative sums of remainders
        for (long a : A) {
            // Calculate the next element in the extended sequence: (currentSum + a) mod M
            // The Python code calculates (hstack([0, A]) % M).cumsum() % M.
            // This means we are calculating the cumulative sum of (A_i mod M) starting from A_0=0.
            
            // Let's re-evaluate the Python logic:
            // R = [0%M, A[0]%M, A[1]%M, ...]
            // cum_remainders = (R).cumsum() % M
            
            // We need to calculate the cumulative sum of the remainders of the extended sequence.
            
            // Let's recalculate based on the structure:
            // We are tracking the cumulative sum