import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Arrays;

public class s016605598 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialization
        long const = 0;
        // left stores negative values (-a) to simulate a max-heap for 'a'
        PriorityQueue<Integer> left = new PriorityQueue<>();
        // right stores positive values
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int q = scanner.nextInt();
        
        // Using long for sums to prevent potential overflow
        long leftSum = 0;
        long rightSum = 0;
        int cnt = 0;

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            
            if (type == 1) {
                // Update operation
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                const += b;

                if (cnt % 2 == 0) {
                    // Even cnt
                    if (right.isEmpty()) {
                        // Case 1: right is empty
                        left.offer(-a);
                        leftSum += a;
                        cnt++;
                        continue;
                    } else {
                        // Case 2: right is not empty
                        int c = right.poll();
                        rightSum -= c;

                        if (a <= c) {
                            // Push -a to left, c back to right
                            left.offer(-a);
                            right.offer(c);
                            leftSum += a;
                            rightSum += c;
                        } else {
                            // Push -c to left, a to right
                            left.offer(-c);
                            right.offer(a);
                            leftSum += c;
                            rightSum += a;
                        }
                    }
                } else {
                    // Odd cnt
                    if (left.isEmpty()) {
                        // Should not happen based on problem logic flow, but handle defensively
                        // If left is empty, we can't pop. Assuming valid state based on Python logic.
                    } else {
                        int c = left.poll();
                        leftSum += c;

                        if (a <= -c) {