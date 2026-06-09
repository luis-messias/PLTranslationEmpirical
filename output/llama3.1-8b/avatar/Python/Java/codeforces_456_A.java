import java.util.Arrays;
import java.util.Scanner;

public class codeforces_456_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] m = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < 2; j++) {
                m[i][j] = Integer.parseInt(input[j]);
            }
        }
        Arrays.sort(m, (a, b) -> Integer.compare(b[1], a[1]));
        int[] a = m[0];
        for (int i = 1; i < n; i++) {
            if (m[i][1] > a[1]) {
                System.out.println("Happy Alex");
                break;
            }
            a = m[i];
        } else {
            System.out.println("Poor Alex");
        }
    }
}