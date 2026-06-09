import java.util.Scanner;

public class s858647829 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read a and b from standard input
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // Check the condition: a % 3 == 0 or b % 3 == 0 or (a + b) % 3 == 0
        if (a % 3 == 0 || b % 3 == 0 || (a + b) % 3 == 0) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
        scanner.close();
    }
}