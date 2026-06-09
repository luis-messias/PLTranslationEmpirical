import java.util.Scanner;
import java.util.Arrays;

public class s267613210 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        int[] dist = new int[A.length - 1 + 1];
        for (int i = 0; i < A.length - 1; i++) {
            dist[i] = A[i + 1] - A[i];
        }
        dist[dist.length - 1] = K + A[0] - A[A.length - 1];
        int maxv = Arrays.stream(dist).max().getAsInt();
        System.out.println(Arrays.stream(dist).sum() - maxv);
    }
}