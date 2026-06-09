import java.util.Scanner;

public class s001486412 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        int n = scanner.nextInt();

        // Read the array elements and calculate the sum of reciprocals
        double below = 0.0;
        for (int i = 0; i < n; i++) {
            int a_i = scanner.nextInt();
            below += 1.0 / a_i;
        }

        // Print 1/below
        System.out.println(1.0 / below);

        scanner.close();
    }
}