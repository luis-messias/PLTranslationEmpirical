import java.util.PriorityQueue;
import java.util.Scanner;

public class atcoder_ABC127_F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());
        int ans1 = 0, ans2 = 0;
        PriorityQueue<Integer> p1 = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> p2 = new PriorityQueue<>((a, b) -> a - b);
        long sumB = 0;
        long sumP1 = 0;
        long sumP2 = 0;

        for (int i = 0; i < q; i++) {
            String[] input = scanner.nextLine().split(" ");
            int[] ql = new int[input.length];
            for (int j = 0; j < input.length; j++) {
                ql[j] = Integer.parseInt(input[j]);
            }

            if (ql[0] == 2) {
                if (p1.size() == p2.size()) {
                    System.out.println(-p2.peek() + " " + (sumP1 - p1.size() * (-p2.peek()) + p2.size() * (-p2.peek()) - sumP2 + sumB));
                } else {
                    System.out.println(p1.peek() + " " + (sumP1 - p1.size() * (p1.peek()) + p2.size() * (p1.peek()) - sumP2 + sumB));
                }
            } else {
                sumB += ql[2];
                if (p1.isEmpty()) {
                    p1.add(ql[1]);
                    sumP1 += ql[1];
                } else if (p1.peek() <= ql[1]) {
                    p1.add(ql[1]);
                    sumP1 += ql[1];
                } else {
                    p2.add(-ql[1]);
                    sumP2 += ql[1];
                }

                if (p1.size() < p2.size()) {
                    int k = p2.poll();
                    p1.add(-k);
                    sumP2 += k;
                    sumP1 -= k;
                }
                if (p1.size() - 1 > p2.size()) {
                    int k = p1.poll();
                    p2.add(-k);
                    sumP1 -= k;
                    sumP2 += k;
                }
            }
        }
    }
}
