import java.util.Scanner;

public class s404600540 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q, h, s, d;
        q = scanner.nextInt();
        h = scanner.nextInt();
        s = scanner.nextInt();
        d = scanner.nextInt();

        int n = scanner.nextInt();
        int min1 = Math.min(Math.min(q * 4, h * 2), Math.min(q * 2 + h, s));
        int min2 = Math.min(min1 * 2, d);

        System.out.println((n % 2) * min1 + (n / 2) * min2);
    }
}