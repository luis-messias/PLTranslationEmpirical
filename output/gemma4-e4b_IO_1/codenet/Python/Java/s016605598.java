import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Arrays;

public class s016605598 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialization
        // Renamed 'const' to 'constVal' to avoid keyword conflict
        long constVal = 0;
        
        // left stores negative values (-a) to simulate a max-heap for 'a'
        // Min-heap implementation stores the smallest element at the root.
        // By storing -a, the smallest element in the heap corresponds to the largest 'a'.
        PriorityQueue<Integer> left = new PriorityQueue<>();
        
        // right stores positive values (min-heap)
        PriorityQueue<Integer> right = new PriorityQueue<>();

        if (!scanner.hasNextInt()) return;
        int q = scanner.nextInt();
        
        // Using long for sums to prevent potential overflow
        long leftSum = 0;
        long rightSum = 0;
        int cnt = 0;

        for (int i = 0; i < q; i++) {
            if (!scanner.hasNextInt()) break;
            int type = scanner.nextInt();
            
            if (type == 1) {
                // Update operation: Read a and b
                if (!scanner.hasNextInt()) break;
                int a = scanner.nextInt();
                if (!scanner.hasNextInt()) break;
                int b = scanner.nextInt();

                constVal += b;

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
                        // c is the smallest element in right (min-heap)
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
                        // Should not happen based on problem logic flow
                    } else {
                        // c is the largest element in 'a' (since left stores -a, popping gives the smallest negative, corresponding to largest positive 'a')
                        // Note: When using PriorityQueue<Integer> for max-heap simulation, poll() retrieves the minimum element.
                        // Since we stored -a, the minimum element is the largest negative number, which corresponds to the largest positive 'a'.
                        int c_neg = left.poll();
                        int c = -c_neg; // c is the actual value popped (the largest element from the previous set)
                        
                        // The Python logic seems to treat the popped value 'c' as the value added to left_sum.
                        // In Python: c = heapq.heappop(left). If left stored -a, c is -a. left_sum += c.
                        // Let's stick to the value stored in the heap for consistency with the Python logic flow.
                        int popped_neg = left.poll();
                        int popped_val = -popped_neg; // This is the value 'a' that was popped.
                        
                        // Re-evaluating the Python logic:
                        // c = heapq.heappop(left) -> c is negative.
                        // left_sum += c -> left_sum decreases by |c|.
                        // Let's use the negative value popped, as per the Python code structure.
                        int c_neg_popped = left.poll();
                        int c_val = -c_neg_popped; // The actual value popped (positive)
                        
                        // Wait, the Python code uses c = heapq.heappop(left) and then left_sum += c.
                        // If left stores -a, then c = -a. left_sum += -a.
                        // Let's stick to the variable name 'c' representing the popped negative value.
                        int c_neg = left.poll();
                        
                        // The value added to left_sum is the negative value popped.
                        leftSum += c_neg; 

                        if (a <= -c_neg) {
                            // Push -a to left, -c_neg back to right
                            left.offer(-a);
                            right.offer(-c_neg);
                            leftSum += a;
                            rightSum -= c_neg;
                        } else {
                            // Push c_neg to left, a to right
                            left.offer(c_neg);
                            right.offer(a);
                            leftSum -= c_neg;
                            rightSum += a;
                        }
                    }
                }
                cnt++;
            } else {
                // Query operation (type 0)
                // tmp = -left[0]
                int tmp =
