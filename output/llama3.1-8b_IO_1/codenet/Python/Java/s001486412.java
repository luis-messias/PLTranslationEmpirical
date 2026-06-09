import java.util.Scanner;

public class s001486412 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        String[] input = scanner.nextLine().split(" ");
        double below = 0;
        for (int i = 0; i < n; i++) {
            try {
                below += 1 / Double.parseDouble(input[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                return;
            }
        }
        if (below == 0) {
            System.out.println("Cannot divide by zero");
            return;
        }
        System.out.println(1 / below);
    }
}
