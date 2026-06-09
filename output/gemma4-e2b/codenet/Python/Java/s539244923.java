import java.util.Scanner;

public class s539244923 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if (k % n == 0) {
            System.out.println(n + k);
        } else {
            System.out.println(k - n);
        }
    }
}