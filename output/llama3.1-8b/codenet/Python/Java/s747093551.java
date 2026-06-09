import java.util.Scanner;
import java.util.Arrays;

public class s747093551 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        int[] x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = scanner.nextInt();
        }

        int[] y = new int[M];
        for (int i = 0; i < M; i++) {
            y[i] = scanner.nextInt();
        }

        Arrays.sort(x);
        Arrays.sort(y);

        System.out.println("No War" + ((x[x.length - 1] < y[0]) ? "" : "War"));
    }
}