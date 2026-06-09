import java.util.PriorityQueue;
import java.util.Scanner;

public class atcoder_ABC137_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        PriorityQueue<int[]> x = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            int day = scanner.nextInt();
            int salary = scanner.nextInt();
            x.offer(new int[]{-day, -salary});
        }

        while (!x.isEmpty()) {
            int[] dS = x.poll();
            int r = m - x.size();

            if (r >= -dS[0]) {
                x.offer(dS);
            } else {
                x.offer(dS);
                x.poll();
            }
        }

        PriorityQueue<Integer> y = new PriorityQueue<>((a, b) -> a - b);
        while (!x.isEmpty()) {
            int[] dS = x.poll();
            if (dS[1] < 0) {
                y.offer(-dS[1]);
            } else {
                y.offer(dS[1]);
            }
        }

        System.out.println(y.stream().mapToInt(Integer::intValue).sum());
    }
}
