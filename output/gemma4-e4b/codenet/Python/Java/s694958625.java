import java.util.Scanner;

public class s694958625 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println((x - a) % b);
        scanner.close();
    }
}