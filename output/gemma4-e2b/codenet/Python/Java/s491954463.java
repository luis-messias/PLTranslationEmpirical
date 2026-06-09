import java.util.ArrayList;
import java.util.Scanner;

public class s491954463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int m = scanner.nextInt();

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        // Read m pairs
        for (int i = 0; i < m; i++) {
            if (!scanner.hasNextInt()) break;
            int a1 = scanner.nextInt();
            if (!scanner.hasNextInt()) break;
            int b1 = scanner.nextInt();
            a.add(a1);
            b.add(b1);
        }

        // Calculate and print results
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