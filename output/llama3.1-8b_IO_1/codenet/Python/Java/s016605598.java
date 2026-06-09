import java.util.PriorityQueue;
import java.util.Scanner;

public class s016605598 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        long constVal = 0;
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> a - b);

        for (int i = 0; i < q; i++) {
            int[] t = new int[2];
            for (int j = 0; j < 2; j++) {
                if (j == 1 && t.length > 2) {
                    break;
                }
                t[j] = scanner.nextInt();
            }
            if (t[0] == 1) {
                int a = t[1], b = (t.length > 2 ? t[2] : 0);
                constVal += b;
                if ((i + 1) % 2 == 0) {
                    if (!right.isEmpty()) {
                        int c = right.poll();
                        left.add(-a);
                        left.add(c);
                        constVal -= c;
                        constVal += a;
                    } else {
                        left.add(-a);
                    }
                } else {
                    int c = left.poll();
                    left.add(a);
                    constVal -= -c;
                    constVal += b;
                }
            } else {
                System.out.println(-left.peek() + (constVal - left.stream().mapToInt(Integer::intValue).sum() + right.stream().mapToInt(Integer::intValue).sum()));
            }
        }
    }
}
