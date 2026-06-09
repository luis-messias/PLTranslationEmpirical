import java.util.Scanner;

public class s103029464 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }
        boolean[] B = new boolean[N];

        for (int i = N - 1; i >= 0; i--) {
            int tmp_sum = 0;
            for (int j = Math.max((i + 1) * 2 - 1, 0); j < N; j += i + 1) {
                if (j < B.length) {
                    tmp_sum ^= A[j];
                    tmp_sum %= 2;
                }
            }
            B[i] = tmp_sum == 1;
        }

        int sumB = 0;
        for (int i = 0; i < N; i++) {
            if (B[i]) {
                sumB++;
            }
        }
        System.out.println(sumB);
        for (int i = 0; i < N; i++) {
            if (B[i]) {
                System.out.print(i + 1 + " ");
            }
        }
    }
}
