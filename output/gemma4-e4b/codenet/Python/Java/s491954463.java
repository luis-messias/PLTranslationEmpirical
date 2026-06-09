import java.util.ArrayList;
import java.util.Scanner;

public class s491954463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        // Read M pairs of inputs
        for (int i = 0; i < m; i++) {
            if (!scanner.hasNextInt()) return;
            int a1 = scanner.nextInt();
            int b1 = scanner.nextInt();
            a.add(a1);
            b.add(b1);
        }

        // Process and print counts for numbers 1 to N
        for (int i = 1; i <= n; i++) {
            int countA = 0;
            for (int val : a) {
                if (val == i) {
                    countA++;
                }
            }

            int countB = 0;
            for (int val : b) {
                if (val == i) {
                    countB++;
                }
            }

            System.out.println(countA + countB);
        }

        scanner.close();
    }
}