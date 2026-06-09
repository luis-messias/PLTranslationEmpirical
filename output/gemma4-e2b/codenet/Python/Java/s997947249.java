import java.util.Scanner;

public class s997947249 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        if (N % K == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
        scanner.close();
    }
}