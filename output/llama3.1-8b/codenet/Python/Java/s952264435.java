import java.util.Scanner;

public class s952264435 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += scanner.nextInt();
        }

        System.out.println((n - sum >= 0) ? (n - sum) : "-1");
    }
}