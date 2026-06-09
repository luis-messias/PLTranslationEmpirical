import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class s269975433 {

    static int N, M, Q;
    static List<int[]> Q_groups = new ArrayList<>();
    static int maxScore = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N, M, Q
        if (!scanner.hasNextInt()) {
            return;
        }
        N = scanner.nextInt();
        M = scanner.nextInt();
        Q = scanner.nextInt();

        // Read Q_groups
        for (int i = 0; i < Q; i++) {
            int[] q = new int[4];
            for (int j = 0; j < 4; j++) {
                q[j] = scanner.nextInt();
            }
            Q_groups.add(q);
        }
        
        scanner.close();

        // Start generating combinations
        int[] currentP = new int[N];
        generateCombinations(0, 1, currentP);

        System.out.println(maxScore);
    }

    /**
     * Recursively generates combinations with replacement (non-decreasing order).
     * @param k The current index being filled (0 to N-1).
     * @param startValue The minimum value allowed for p[k] (1 to M).
     * @param currentP The array storing the combination being built.
     */
    private static void generateCombinations(int k, int startValue, int[] currentP) {
        if (k == N) {
            // Found a complete combination p
            calculateScore(currentP);
            return;
        }

        // Iterate through possible values for p[k]
        for (int val = startValue; val <= M; val++) {
            currentP[k] = val;
            // Recurse for the next index, ensuring the next value is >= current value
            generateCombinations(k + 1, val, currentP);
        }
    }

    private static void calculateScore(int[] p) {
        int tempScore = 0;
        
        // Iterate through all queries
        for (int[] q : Q_groups) {
            // q[0] and q[1] are 1-based indices.
            // q[2] is the required difference.
            // q[3] is the score weight.
            
            // Check if p[q[1] - 1] - p[q[0] - 1] == q[2]
            if (p[q[1] - 1] - p[q[0] - 1] == q[2]) {
                tempScore += q[3];
            }
        }
        
        // Update maxScore
        maxScore = Math.max(maxScore, tempScore);
    }
}
