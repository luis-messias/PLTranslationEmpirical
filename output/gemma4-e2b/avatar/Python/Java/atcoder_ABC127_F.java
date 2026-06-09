import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class atcoder_ABC127_F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read q
        if (!scanner.hasNextInt()) return;
        int q = scanner.nextInt();

        // Initialize heaps (p1 and p2)
        // Python's heapq is a min-heap.
        // p1 and p2 are initialized as lists and heapified.
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        PriorityQueue<Integer> p2 = new PriorityQueue<>();

        // sum_b, sum_p1, sum_p2
        long sum_b = 0;
        long sum_p1 = 0;
        long sum_p2 = 0;

        // The Python code initializes p1 and p2 as empty lists and then heapifies them.
        // Since we are using PriorityQueue, they are naturally heap structures.

        for (int i = 0; i < q; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine();
            String[] parts = line.trim().split("\\s+");
            
            if (parts.length == 0) continue;

            int ql0 = Integer.parseInt(parts[0]);
            int ql1 = Integer.parseInt(parts[1]);
            int ql2 = Integer.parseInt(parts[2]);

            if (ql0 == 2) {
                // Case ql[0] == 2
                if (p1.size() == p2.size()) {
                    // print ( - p2[0] , sum_p1 - len(p1) * - p2[0] + len(p2) * - p2[0] - sum_p2 + sum_b )
                    // Note: p2[0] is the smallest element in p2 (which is the largest negative value, i.e., the smallest magnitude negative number)
                    // Since p2 is a min-heap, p2.peek() gives the smallest element.
                    // The Python code uses -p2[0] which is the largest element in p2 (least negative).
                    
                    // Let's stick to the Python logic: p2[0] is the smallest element in p2.
                    // If p2 is a min-heap, p2.peek() is the smallest element.
                    // The Python code uses -p2[0]. If p2 stores negative values, -p2[0] is the magnitude.
                    
                    // Assuming p2 stores negative values, and we want the actual value:
                    // If p2 stores [-5, -3], p2[0] = -5. -p2[0] = 5.
                    
                    long result = -p2.peek() + (sum_p1 - (long)p1.size() * (-p2.peek()) + (long)p2.size() * (-p2.peek()) - sum_p2 + sum_b);
                    System.out.println(result);
                } else {
                    // print ( p1[0] , sum_p1 - len(p1) * p1[0] + len(p2) * p1[0] - sum_p2 + sum_b )
                    long result = p1.peek() + (sum_p1 - (long)p1.size() * p1.peek() + (long)p2.size() * p1.peek() - sum_p2 + sum_b);
                    System.out.println(result);
                }
            } else {
                // Case ql[0] != 2
                sum_b += ql2;
                int val = ql1;

                if (p1.isEmpty()) {
                    // heapq.heappush ( p1 , ql[1] )
                    p1.add(val);
                    sum_p1 += val;
                } else if (p1.peek() <= val) {
                    // heapq.heappush ( p1 , ql[1] )
                    p1.add(val);
                    sum_p1 += val;
                } else {
                    // heapq.heappush ( p2 , - ql[1] )
                    p2.add(-val);
                    sum_p2 += val; // sum_p2 += ql[1] (since we pushed -val, we add val)
                }

                // Balancing logic
                //