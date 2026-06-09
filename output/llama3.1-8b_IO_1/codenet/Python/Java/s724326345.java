import java.util.Scanner;

public class s724326345 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A, B, C, X, Y;
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();
        X = scanner.nextInt();
        Y = scanner.nextInt();

        long ans = (long) 1e10;

        for (int k = Math.max(X, Y); k >= Math.min(X, Y); k--) {
            int total = 2 * C * k + A * Math.max(0, X - k) + B * Math.max(0, Y - k);
            if (total < ans) {
                ans = total;
            }
        }

        System.out.println(ans);
    }
}
