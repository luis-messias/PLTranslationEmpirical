import java.util.Scanner;
import java.lang.Math;

public class s663509070 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt();

        int[][] mat = new int[N][D];
        for (int d = 0; d < N; d++) {
            for (int i = 0; i < D; i++) {
                mat[d][i] = scanner.nextInt();
            }
        }

        int c = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double dist = Math.sqrt(sumOfSquares(mat[i], mat[j]));
                if (dist == Math.floor(dist)) {
                    c++;
                }
            }
        }

        System.out.println(c);
    }

    public static int sumOfSquares(int[] arr1, int[] arr2) {
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += Math.pow(arr1[i] - arr2[i], 2);
        }
        return sum;
    }
}