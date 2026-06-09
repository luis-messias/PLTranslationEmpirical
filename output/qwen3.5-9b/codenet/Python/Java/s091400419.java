import java.util.Scanner;

public class s091400419 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = a + b;
        int diff = a - b;
        int prod = a * b;
        int max = Math.max(sum, Math.max(diff, prod));
        System.out.println(max);
    }
}