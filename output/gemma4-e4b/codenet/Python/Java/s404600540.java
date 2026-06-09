import java.util.Scanner;
import java.lang.Math;

public class s404600540 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read q, h, s, d
        int q = scanner.nextInt();
        int h = scanner.nextInt();
        int s = scanner.nextInt();
        int d = scanner.nextInt();

        // Read n
        int n = scanner.nextInt();

        scanner.close();

        // min_1 = min(q*4, h*2, q*2+h, s)
        int min_1 = Math.min(q * 4, Math.min(h * 2, Math.min(q * 2 + h, s)));

        // min_2 = min(min_1*2, d)
        int min_2 = Math.min(min_1 * 2, d);

        // Calculate and print the result: (n % 2)*min_1 + (n / 2)*min_2
        int result = (n % 2) * min_1 + (n / 2) * min_2;

        System.out.println(result);
    }
}