import java.util.Scanner;
import java.util.Arrays;

public class s491954463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] a = new int[m][2];
        int[][] b = new int[m][2];

        for (int i = 0; i < m; i++) {
            input = scanner.nextLine().split(" ");
            a[i][0] = Integer.parseInt(input[0]);
            a[i][1] = Integer.parseInt(input[1]);
            b[i][0] = a[i][0];
            b[i][1] = a[i][1];
        }

        for (int i = 1; i <= n; i++) {
            int countA = 0;
            int countB = 0;
            for (int j = 0; j < m; j++) {
                if (a[j][0] == i) countA++;
                if (b[j][0] == i) countB++;
            }
            System.out.println(countA + countB);
        }
    }
}