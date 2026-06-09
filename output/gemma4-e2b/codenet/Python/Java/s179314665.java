import java.util.Scanner;

public class s179314665 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the two space-separated integers
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        if (A < 10 && B < 10) {
            System.out.println(A * B);
        } else {
            System.out.println(-1);
        }
        scanner.close();
    }
}