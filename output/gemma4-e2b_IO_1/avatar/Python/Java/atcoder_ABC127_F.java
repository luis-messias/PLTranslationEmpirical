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
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        PriorityQueue<Integer> p2 = new PriorityQueue<>();

        // sum_b, sum_p1, sum_p2. Use long for sums to prevent potential overflow.
        long sum_b = 0;
        long sum_p1 = 0;
        long sum_p2 = 0;

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
                    // print ( - p2[0] , sum_p1 - len(p1) * -p2[0] + len(p2) * -p2[0] - sum_p2 + sum_b )
                    // p2.peek() is the smallest element in p2.
                    long val_p2_0 = p2.peek();
                    long result = -val_p2_0 + (sum_p1 - (long)p1.size() * (-val_p2_0) + (long)p2.size() * (-val_p2_0) - sum_p2 + sum_b);
                    System.out.println(result);
                } else {
                    // print ( p1[0] , sum_p1 - len(p1) * p1[0] +
