import java.util.Scanner;

public class s923405856 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (!scanner.hasNextInt()) {
                break;
            }
            int n = scanner.nextInt();

            if (n == 0) {
                break;
            }

            // Initialize res to a sufficiently small number, matching the Python literal
            long res = -1111111111L;
            long s = 0;

            for (int i = 0; i < n; i++) {
                if (!scanner.hasNextInt()) {
                    // Stop if input runs out unexpectedly
                    break;
                }
                int a = scanner.nextInt();

                // s = max(s + a, a)
                s = Math.max(s + a, a);

                // res = max(s, res)
                res = Math.max(s, res);
            }

            System.out.println(res);
        }
    }
}