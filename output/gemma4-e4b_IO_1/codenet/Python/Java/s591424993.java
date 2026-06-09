import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;

public class s591424993 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read D and G
        // Assuming D and G fit within standard integer limits for the problem constraints, 
        // but using long for safety based on the original Java attempt.
        long dLong = scanner.nextLong();
        long g = scanner.nextLong();
        int d = (int) dLong;

        // Read pc array
        long[][] pc = new long[d][2];
        for (int i = 0; i < d; i++) {
            pc[i][0] = scanner.nextLong();
            pc[i][1] = scanner.nextLong();
        }
        
        scanner.close();

        long ans = Long.MAX_VALUE;

        // Iterate through all 2^d subsets
        for (int bit = 0; bit < (1 << d); bit++) {
            long count = 0;
            long sum = 0;
            Set<Integer> nokori = new HashSet<>();
            for (int i = 1; i <= d; i++) {
                nokori.add(i);
            }

            // Calculate initial sum and count based on the subset 'bit'
            for (int i = 0; i < d; i++) {
                if ((bit & (1 << i)) != 0) {
                    // i+1 is the index (1-based)
                    sum += pc[i][0] * (i + 1) * 100 + pc[i][1];
                    count += pc[i][0];
                    nokori.remove(i + 1);
                }
            }
            
            // Greedy step: Use the largest remaining index 'use' if sum < g
            if (sum < g) {
                // Find max remaining
