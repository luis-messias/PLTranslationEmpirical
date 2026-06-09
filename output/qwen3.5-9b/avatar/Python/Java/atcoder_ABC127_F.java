import java.util.*;
import java.io.*;

public class atcoder_ABC127_F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        PriorityQueue<Integer> p2 = new PriorityQueue<>(Collections.reverseOrder());
        long sum_b = 0;
        long sum_p1 = 0;
        long sum_p2 = 0;
        
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int val = sc.nextInt();
            int b = sc.nextInt();
            
            if (type == 2) {
                if (p1.size() == p2.size()) {
                    long median = -p2.peek();
                    long ans = sum_p1 - (long)p1.size() * median + (long)p2.size() * median - sum_p2 + sum_b;
                    System.out.println(median + " " + ans);
                } else {
                    long median = p1.peek();
                    long ans = sum_p1 - (long)p1.size() * median + (long)p2.size() * median - sum_p2 + sum_b;
                    System.out.println(median + " " + ans);
                }
            } else {
                sum_b += b;
                if (p1.isEmpty()) {
                    p1.add(val);
                    sum_p1 += val;
                } else if (p1.peek() <= val) {
                    p1.add(val);
                    sum_p1 += val;
                } else {
                    p2.add(-val);
                    sum_p2 += val;
                }
                if (p1.size() < p2.size()) {
                    int k = -p2.poll();
                    p1.add(k);
                    sum_p2 += k;
                    sum_p1 -= k;
                }
                if (p1.size() - 1 > p2.size()) {
                    int k = p1.poll();
                    p2.add(-k);
                    sum_p1 -= k;
                    sum_p2 += k;
                }
            }
        }
    }
}