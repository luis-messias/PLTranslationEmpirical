import java.util.Arrays;
import java.util.Scanner;

public class s828550015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        int x = Integer.parseInt(input1[0]);
        int y = Integer.parseInt(input1[1]);
        String[] input2 = scanner.nextLine().split(" ");
        String[] input3 = scanner.nextLine().split(" ");
        String[] input4 = scanner.nextLine().split(" ");

        int[] p = Arrays.stream(input2).mapToInt(Integer::parseInt).sorted((a, b) -> b - a).limit(x).toArray();
        int[] q = Arrays.stream(input3).mapToInt(Integer::parseInt).sorted((a, b) -> b - a).limit(y).toArray();
        int[] r = Arrays.stream(input4).mapToInt(Integer::parseInt).sorted((a, b) -> b - a).toArray();

        int[] pq = new int[x + y];
        System.arraycopy(p, 0, pq, 0, x);
        System.arraycopy(q, 0, pq, x, y);

        for (int i = 0; i < Math.min(x + y, r.length); i++) {
            if (pq[i] < r[i]) {
                pq[i] = r[i];
            }
        }

        int sum = Arrays.stream(pq).sum();
        System.out.println(sum);
    }
}