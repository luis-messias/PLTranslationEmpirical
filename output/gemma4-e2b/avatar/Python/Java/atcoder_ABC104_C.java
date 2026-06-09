import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC104_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read D and G
        if (!scanner.hasNextInt()) return;
        int D = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        long G = scanner.nextLong();

        // Read PC data
        // PC[j][0] and PC[j][1] for j = 0 to D-1
        long[][] PC = new long[D][2];
        for (int j = 0; j < D; j++) {
            if (!scanner.hasNextLong()) return;
            PC[j][0] = scanner.nextLong();
            if (!scanner.hasNextLong()) return;
            PC[j][1] = scanner.nextLong();
        }

        long ans = 1_000_000_000L; // 10^9

        // Iterate through all 2^D subsets
        int numSubsets = 1 << D;
        for (int i = 0; i < numSubsets; i++) {
            long score = 0;
            long problem = 0;

            // Calculate score and problem cost for the selected subset i
            for (int j = 0; j < D; j++) {
                // Check if j-th bit is set
                if (((i >> j) & 1) == 1) {
                    // Selected
                    // score += 100 * (j + 1) * PC[j][0] + PC[j][1]
                    score += 100L * (j + 1) * PC[j][0] + PC[j][1];
                    // problem += PC[j][0]
                    problem += PC[j][0];
                }
            }

            if (score > G) {
                continue;
            }

            long left = G - score;

            // Try to spend the remaining budget 'left' on unselected problems
            for (int j = 0; j < D; j++) {
                // Check if j-th bit is NOT set (unselected)
                if (((i >> j) &