import java.util.PriorityQueue;
import java.util.Scanner;

public class s763208424 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            pq.add(-val);
        }
        
        for (int i = 0; i < m; i++) {
            int val = -pq.poll();
            int newVal = val / 2;
            pq.add(-newVal);
        }
        
        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        
        System.out.println(-sum);
    }
}