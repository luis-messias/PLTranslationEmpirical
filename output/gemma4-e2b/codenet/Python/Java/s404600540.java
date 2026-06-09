import java.util.Scanner;

public class s404600540 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read q, h, s, d
        long q = scanner.nextLong();
        long h = scanner.nextLong();
        long s = scanner.nextLong();
        long d = scanner.nextLong();

        // Read n
        long n = scanner.nextLong();

        // min_1 = min(q*4, h*2, q*2+h, s)
        long min1 = Math.min(q * 4, Math.min(h * 2, q * 2 + h));
        min1 = Math.min(min1, s);

        // min_2 = min(min_1*2, d)
        long min2 = Math.min(min1 * 2, d);

        // print((n % 2)*min_1 + (n // 2)*min_2)
        long result = (n % 2) * min1 + (n / 2) * min2;

        System.out.println(result);
    }
}