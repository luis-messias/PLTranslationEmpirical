import java.util.Scanner;

public class s040517919 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read A and B from a single line of input
        if (scanner.hasNextInt()) {
            int A = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int B = scanner.nextInt();

                if (A == B) {
                    System.out.println("Draw");
                } else if (A == 1) {
                    System.out.println("Alice");
                } else if (B == 1) {
                    System.out.println("Bob");
                } else if (A > B) {
                    System.out.println("Alice");
                } else {
                    System.out.println("Bob");
                }
            }
        }
        scanner.close();
    }
}