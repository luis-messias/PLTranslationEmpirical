import java.util.Scanner;

public class s246930871 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int sum = A + B;
        int quotient = N / sum;
        int remainder = N % sum;

        int ans = A * quotient + Math.min(A, remainder);

        System.out.println(ans);
    }
}