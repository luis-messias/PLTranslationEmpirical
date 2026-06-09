import java.util.PriorityQueue;
import java.util.Scanner;

public class s016605598 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // const is implicitly handled by tracking sums and the updates, 
        // but we need a variable to store the accumulated constant value.
        long constVal = 0;
        
        // left and right are used as heaps. 
        // Python's heapq is a min-heap.
        // To simulate the logic where we push -a to left, left acts like a max-heap 
        // (storing negative values).
        PriorityQueue<Long> left = new PriorityQueue<>();
        PriorityQueue<Long> right = new PriorityQueue<>();

        // cnt tracks the step number (parity matters)
        int cnt = 0;
        long leftSum = 0;
        long rightSum = 0;

        if (!scanner.hasNextInt()) return;
        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            if (!scanner.hasNextInt()) break;
            int type = scanner.nextInt();

            if (type == 1) {
                // Update operation
                if (!scanner.hasNextLong()) break;
                long a = scanner.nextLong();
                long b = scanner.nextLong();

                constVal += b;

                if (cnt % 2 == 0) {
                    // Even step
                    if (right.isEmpty()) {
                        // if not right:
                        left.add(-a);
                        leftSum += a; // Note: leftSum += a, since we stored -a in left
                        cnt += 1;
                        continue;
                    }

                    // c = heapq.heappop(right)
                    long c = right.poll();
                    rightSum -= c;

                    if (a <= c) {
                        // heapq.heappush(left, -a)
                        left.add(-a);
                        // heapq.heappush(right, c)
                        right.add(c);
                        leftSum += a;
                        rightSum += c;
                    } else {
                        // heapq.heappush(left, -c)
                        left.add(-c);
                        // heapq.heappush(right, a)
                        right.add(a);
                        leftSum += c;
                        rightSum += a;
                    }
                } else {
                    // Odd step
                    // c = heapq.heappop(left)
                    long c = left.poll();
                    leftSum += c;

                    if (a <= -c) {
                        // heapq.heappush(left, -a)
                        left.add(-a);
                        // heapq.heappush(right, -c)
                        right.add(-c);
                        leftSum += a;
                        rightSum -= c;
                    } else {
                        // heapq.heappush(left, c)
                        left.add(c);
                        // heapq.heappush(right, a)
                        right.add(a);
                        leftSum -= c;
                        rightSum += a;
                    }
                }
                cnt += 1;
            } else {
                // Query operation (type == 0)
                if (left.isEmpty()) {
                    // Handle case where left might be empty, though logic implies it shouldn't be
                    // based on the Python code structure.
                    System.out.println(constVal + rightSum);
                } else {
                    // tmp = -left[0] (left[0] is the smallest negative number, so -left[0] is the largest positive value)
                    long tmp = -left.peek();
                    // print(tmp, const - left_sum + right_sum + tmp * (cnt % 2))
                    System.out.println(tmp + constVal - leftSum + rightSum + tmp * (cnt % 2));
                }
            }
        }
        scanner.close();
    }
}