import java.util.Scanner;
import java.util.Arrays;

public class s913338871 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Read the array a
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        String[] tokens = line.split("\\s+");

        int[] a = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            // Handle potential empty strings if input formatting is tricky, though split("\\s+") usually handles this well.
            if (!tokens[i].isEmpty()) {
                a[i] = Integer.parseInt(tokens[i]);
            }
        }

        // Sort a
        Arrays.sort(a);

        // Select elements a[N::2] (indices N, N+2, N+4, ...) and sum them
        long sum = 0;
        for (int i = N; i < a.length; i += 2) {
            sum += a[i];
        }

        System.out.println(sum);

        scanner.close();
    }
}
