import java.util.*;

public class atcoder_ABC137_D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        PriorityQueue<int[]> x = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        
        PriorityQueue<Integer> y = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            int day = sc.nextInt();
            int salary = sc.nextInt();
            x.offer(new int[]{-day, -salary});
        }
        
        while (!x.isEmpty()) {
            int[] item = x.poll();
            int d = item[0];
            int s = item[1];
            int r = m - y.size();
            if (r >= -d) {
                y.offer(-s);
            } else {
                y.offer(-s);
                y.poll();
            }
        }
        
        int sum = 0;
        for (int val : y) {
            sum += val;
        }
        System.out.println(sum);
    }
}
