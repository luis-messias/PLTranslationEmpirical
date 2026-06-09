import java.util.Scanner;
import java.util.Arrays;

public class codeforces_306_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        int q = n / m;
        int r = n % m;

        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = q;
        }

        for (int i = 0; i < r; i++) {
            a[i]++;
        }

        for (int i = 0; i < m; i++) {
            System.out.print(a[i] + (i == m - 1 ? "" : " "));
        }
        System.out.println();
    }
}