import java.util.Scanner;

public class s246930871 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int ans = A * (N / (A + B)) + Math.min(A, N % (A + B));
        System.out.println(ans);
    }
}