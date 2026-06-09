import java.util.Arrays;
import java.util.Scanner;

public class s846046431 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        Arrays.sort(A);
        long S = 0;
        for (int a : A) {
            S += a;
        }
        boolean flag = false;
        for (int i = 0; i < M && !flag; i++) {
            if ((double)A[i] / S - 1.0 / (4 * M) < 0) {
                System.out.println("No");
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Yes");
        }
    }
}
