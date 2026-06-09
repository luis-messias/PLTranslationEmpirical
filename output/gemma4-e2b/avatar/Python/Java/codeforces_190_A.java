import java.util.Scanner;

public class codeforces_190_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) {
            return;
        }
        int m = scanner.nextInt();

        if (n < 1) {
            if (m < 1) {
                System.out.println(n + " " + m);
            } else {
                System.out.println("Impossible");
            }
        } else if (m > n) {
            int min = m;
            int max = n + m - 1;
            System.out.println(min + " " + max);
        } else { // m <= n
            int min = n;
            int max = n + m - 1;
            if (m == 0) {
                max = n;
            }
            System.out.println(min + " " + max);
        }
        scanner.close();
    }
}