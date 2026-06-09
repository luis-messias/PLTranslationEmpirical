import java.util.Scanner;

public class s170274782 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[][] A = new int[2][N];

        for (int i = 0; i < 2; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j <= i; j++) {
                count += A[0][j];
            }
            for (int j = i; j < N; j++) {
                count += A[1][j];
            }
            ans[i] = count;
        }

        int max = Integer.MIN_VALUE;
        for (int i : ans) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println(max);
    }
}