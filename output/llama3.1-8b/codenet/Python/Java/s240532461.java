import java.util.Arrays;
import java.util.Scanner;

public class s240532461 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();

        int[] aji = new int[N];
        for (int i = 0; i < N; i++) {
            aji[i] = L + i;
        }

        if (Arrays.stream(aji).min().getAsInt() >= 0) {
            Arrays.sort(aji);
            aji[0] = Integer.MAX_VALUE;
        } else if (Arrays.stream(aji).max().getAsInt() <= 0) {
            Arrays.sort(aji);
            aji[N - 1] = Integer.MIN_VALUE;
        } else {
            int minIndex = 0;
            for (int i = 1; i < N; i++) {
                if (Math.abs(aji[i]) < Math.abs(aji[minIndex])) {
                    minIndex = i;
                }
            }
            aji[minIndex] = Integer.MAX_VALUE;
        }

        int sum = Arrays.stream(aji).sum();
        System.out.println(sum);
    }
}