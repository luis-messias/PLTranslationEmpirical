import java.util.Scanner;

public class s702834515 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read n
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int r = 0;
            // Iterate from 1 to n (corresponding to ii+1 in Python)
            for (int i = 1; i <= n; i++) {
                // Check if i is not divisible by 3 AND not divisible by 5
                if (i % 3 != 0 && i % 5 != 0) {
                    r += i;
                }
            }
            System.out.println(r);
        }
        scanner.close();
    }
}