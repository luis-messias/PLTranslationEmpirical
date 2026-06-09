import java.util.Scanner;

public class s398580870 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if (k % 2 == 1) {
            System.out.println((n / k) * (n / k) * (n / k));
        } else {
            System.out.println(Math.pow((n + k / 2) / k, 3));
        }
    }
}
