import java.util.Scanner;

public class s310981504 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a <= b) {
            System.out.println(a);
        } else {
            System.out.println(a - 1);
        }
        scanner.close();
    }
}