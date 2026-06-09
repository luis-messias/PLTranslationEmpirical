import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class s289483518 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Read array a
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Sort a
        Arrays.sort(a);

        // Read operations ope
        // Each operation is [cost, value]
        // We use a custom class or array structure to hold the pair and allow sorting.
        // Since the cost and value are integers, we can use int[][] or a custom Pair class.
        // Using int[][] where ope[i][0] = cost, ope[i][1] = value.
        int[][] ope = new int[m][2];
        for (int i = 0; i < m; i++) {
            ope[i][0] = scanner.nextInt(); // Cost
            ope[i][1] = scanner.nextInt(); // Value
        }

        // Sort ope based on value (index 1) in descending order
        Arrays.sort(ope, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // Compare o2[1] to o1[1] for descending order
                return Integer.compare(o2[1], o1[1]);
            }
        });

        int j = 0; // Index for ope
        
        for (int i = 0; i < n; i++) {
            // Check if we ran out of operations
            if (j >= m) {
                break;
            }
            
            // Check condition: a[i] < ope[j][1]
            if (a[i] < ope[j][1]) {
                // Apply operation
                a[i] = ope[j][1];
                ope[j][0] -= 1; // Decrease cost
                
                if (ope[j][0] == 0) {
                    // Operation exhausted, move to the next one
                    j++;
                }
            } else {
                // Condition not met, since a is sorted, we break
                break;
            }
        }

        // Calculate and print the sum of a
        long sum = 0;
        for (int x : a) {
            sum += x;
        }
        System.out.println(sum);
        
        scanner.close();
    }
}