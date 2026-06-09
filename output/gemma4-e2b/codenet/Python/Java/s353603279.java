import java.util.Scanner;

public class s353603279 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read X
        int X = scanner.nextInt();

        // h = X // 500
        int h = X / 500;

        // a = (X % 500) // 5
        int remainder = X % 500;
        int a = remainder / 5;

        // y = h * 1000 + a * 5
        int y = h * 1000 + a * 5;

        System.out.println(y);
    }
}