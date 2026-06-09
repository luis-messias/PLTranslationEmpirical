import java.util.Scanner;

public class s310981504 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);

        if (a <= b) {
            System.out.println(a);
        } else {
            System.out.println(a - 1);
        }
        scanner.close();
    }
}