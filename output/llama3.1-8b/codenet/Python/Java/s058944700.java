import java.util.Scanner;

public class s058944700 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if (n > k) {
            int tmp = n % k;
            if (tmp >= k - tmp) {
                System.out.println(k - tmp);
            } else {
                System.out.println(tmp);
            }
        } else if (n < k) {
            if (n >= k - n) {
                System.out.println(k - n);
            } else {
                System.out.println(n);
            }
        } else {
            System.out.println(0);
        }
    }
}