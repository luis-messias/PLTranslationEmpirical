import java.util.Scanner;

public class s208095748 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read A, B, C from a single line of input
        if (scanner.hasNextInt()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();

            if (B < C) {
                System.out.println(0);
            } else if (A * C < B) {
                System.out.println(C);
            } else {
                // Integer division in Java handles B // A
                System.out.println(B / A);
            }
        }
        scanner.close();
    }
}