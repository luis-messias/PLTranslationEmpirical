import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class s289483518 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m
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
        List<List<Integer>> ope = new ArrayList<>();
        for (int k = 0; k < m; k++) {
            List<Integer> op = new ArrayList<>();
            op.add(scanner.nextInt()); // value
            op.add(scanner.nextInt()); // count
            ope.add(op);
        }

        // Sort ope based on the second element (count) in reverse order (descending)
        Collections.sort(ope, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                // Sort by the second element (index 1) in descending order
                return o2.get(1).compareTo(o1.get(1));
            }
        });

        // Apply operations greedily
        int j = 0;
        for (int i = 0; i < n; i++) {
            // Check if the current element a[i] can be increased by the current best operation ope[j]
            if (j < ope.size() && a[i] < ope.get(j).get(1)) {
                // Update a[i]
                a[i] = ope.get(j).get(1);
                
                // Decrement the count of the operation
                ope.get(j).set(0, ope.get(j).get(0) - 1);
                
                // If the count reaches 0, move to the next operation
                if (ope.get(j).get(0) == 0) {
                    j++;
                }
            } else {
                // If a[i] is already >= ope[j][1], no further operations (which are sorted by max value) will help this element, so we break.
                break;
            }
        }

        // Calculate and print the sum
        long sum = 0;
        for (int val : a) {
            sum += val;
        }
        System.out.println(sum);
        
        scanner.close();
    }
}