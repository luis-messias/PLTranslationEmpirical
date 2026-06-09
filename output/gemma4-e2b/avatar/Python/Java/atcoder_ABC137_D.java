import java.util.PriorityQueue;
import java.util.Scanner;

public class atcoder_ABC137_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int m = scanner.nextInt();

        // x will store pairs (-day, -salary)
        // We use an array or custom object for pairs in the PQ.
        // Since we are dealing with integers, we can store them as arrays or custom objects.
        // Let's use an array of int arrays or a custom class for simplicity in PQ.
        
        // In Java, we use a structure to hold the pair (-day, -salary)
        // We'll use an array of int arrays for simplicity, where [0] is -day and [1] is -salary.
        PriorityQueue<int[]> x = new PriorityQueue<>((a, b) -> {
            // Sort primarily by -day (ascending), then by -salary (ascending)
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // y will store -salary values
        PriorityQueue<Integer> y = new PriorityQueue<>();

        // Read n pairs of day and salary
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) break;
            int day = scanner.nextInt();
            if (!scanner.hasNextInt()) break;
            int salary = scanner.nextInt();

            // Push (-day, -salary) into x
            x.offer(new int[]{-day, -salary});
        }

        // Process the heap
        while (!x.isEmpty()) {
            int[] item = x.poll();
            int d = item[0]; // d = -day
            int s = item[1]; // s = -salary

            int r = m - y.size(); // r = m - len(y)

            // The condition is r >= -d, which is m - len(y) >= day
            if (r >= -d) {
                // Push -s (which is salary) to y
                y.offer(-s);
            } else {
                // Push -s to y
                y.offer(-s);
                // Pop an element from y
                y.poll();
            }
        }

        // Calculate the sum of y
        long sumY = 0;
        for (int val : y) {
            sumY += val;
        }

        System.out.println(sumY);
        
        scanner.close();
    }
}