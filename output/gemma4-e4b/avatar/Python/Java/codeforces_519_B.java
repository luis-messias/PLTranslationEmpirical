import java.util.Scanner;
import java.lang.Math;

public class codeforces_519_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read N (unused variable, but must consume input)
        if (scanner.hasNextInt()) {
            scanner.nextInt();
        }
        
        // Consume the rest of the line after reading N, to prepare for reading the lists.
        scanner.nextLine(); 

        long x = 0;
        long y = 0;
        long z = 0;

        // Helper function to read a line and calculate the sum
        java.util.function.Function<String, Long> calculateSum = (line) -> {
            if (line == null || line.trim().isEmpty()) {
                return 0L;
            }
            String[] parts = line.trim().split("\\s+");
            long sum = 0;
            for (String part : parts) {
                if (!part.isEmpty()) {
                    try {
                        sum += Long.parseLong(part);
                    } catch (NumberFormatException e) {
                        // Ignore non-integer parts if they somehow appear
                    }
                }
            }
            return sum;
        };

        // 2. Read list A and calculate sum X
        String lineA = scanner.nextLine();
        x = calculateSum.apply(lineA);

        // 3. Read list B and calculate sum Y
        String lineB = scanner.nextLine();
        y = calculateSum.apply(lineB);

        // 4. Read list C and calculate sum Z
        String lineC = scanner.nextLine();
        z = calculateSum.apply(lineC);

        // 5. Output |x - y|
        System.out.println(Math.abs(x - y));

        // 6. Output |y - z|
        System.out.println(Math.abs(y - z));

        scanner.close();
    }
}