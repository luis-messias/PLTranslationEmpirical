import java.util.Scanner;
import java.lang.Math;

public class s814885508 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read X, K, D
        if (!scanner.hasNextInt()) {
            return;
        }
        int X = scanner.nextInt();
        int K = scanner.nextInt();
        int D = scanner.nextInt();

        // r = X // D (Integer division)
        int r = X / D;

        // if abs(r) > K:
        if (Math.abs(r) > K) {
            // print(abs(X) - K * D)
            System.out.println(Math.abs(X) - K * D);
            return;
        }

        // a = X - r * D
        int a = X - r * D;

        // if (K - r) % 2 == 0:
        if ((K - r) % 2 == 0) {
            // print(a)
            System.out.println(a);
        } else {
            // print(abs(D - a))
            System.out.println(Math.abs(D - a));
        }
    }
}