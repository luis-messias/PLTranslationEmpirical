import java.util.Scanner;

public class s398580870 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);

        if (k % 2 != 0) {
            System.out.println(Math.pow(n / k, 3));
        } else {
            long term1 = (long) (n / k) * (n / k) * (n / k);
            long term2 = (long) ((n + k / 2) / k) * ((n + k / 2) / k) * ((n + k / 2) / k);
            System.out.println(term1 + term2);
        }
        scanner.close();
    }
}