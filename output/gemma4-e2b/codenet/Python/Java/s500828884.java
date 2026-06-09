import java.util.Scanner;

public class s500828884 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read n, a, b from a single line of input
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // Calculate min(n * a, b)
            int result = Math.min(n * a, b);

            // Print the result
            System.out.println(result);
        }
    }
}