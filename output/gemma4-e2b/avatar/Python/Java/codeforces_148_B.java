import java.util.Scanner;

public class codeforces_148_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read inputs
        int princess = scanner.nextInt();
        int dragon = scanner.nextInt();
        int t = scanner.nextInt();
        int f = scanner.nextInt();
        int c = scanner.nextInt();

        // Check condition
        if (dragon <= princess) {
            System.out.println(0);
            return; // Equivalent to exit(0)
        }

        // Use double for position to handle potential floating-point results from division
        double result = 0;
        double position = (double) t * princess;

        // First calculation
        // position += princess * position / ( dragon - princess )
        position += (double) princess * position / (dragon - princess);

        // Loop
        while (position < c) {
            result += 1;
            // position += princess * position / dragon
            position += (double) princess * position / dragon;
            // position += princess * f
            position += (double) princess * f;
            // position += princess * position / ( dragon - princess )
            position += (double) princess * position / (dragon - princess);
        }

        System.out.println(result);

        scanner.close();
    }
}