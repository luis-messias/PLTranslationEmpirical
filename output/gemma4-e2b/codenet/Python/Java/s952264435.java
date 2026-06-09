import java.util.Scanner;

public class s952264435 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M from the first line
        if (!scanner.hasNextInt()) return;
        int N = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        // M is read but ignored, matching the Python logic
        scanner.nextInt(); 

        // Read the elements of A (N elements)
        long A_sum = 0;
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) return;
            int a = scanner.nextInt();
            A_sum += a;
        }

        // Calculate N - A_sum
        long result = N - A_sum;

        // Print the result based on the condition
        if (result >= 0) {
            System.out.println(result);
        } else {
            System.out.println("-1");
        }
    }
}