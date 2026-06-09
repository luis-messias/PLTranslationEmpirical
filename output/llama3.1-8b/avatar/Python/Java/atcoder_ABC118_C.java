import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC118_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        int gcd = Arrays.stream(A).reduce((a, b) -> fractions.gcd(a, b)).getAsInt();
        System.out.println(gcd);
    }
}