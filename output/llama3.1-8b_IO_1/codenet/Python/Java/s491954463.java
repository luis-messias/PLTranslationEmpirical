import java.util.Scanner;

public class s491954463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] a = new int[m];
        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            input = scanner.nextLine().split(" ");
            a[i] = Integer.parseInt(input[0]);
            b[i] = Integer.parseInt(input[1]);
        }

        for (int i = 1; i <= n; i++) {
            int countA = 0;
            int countB = 0;
            for (int j = 0; j < m; j++) {
                if (a[j] == i) countA++;
                if (b[j] == i) countB++;
            }
            System.out.println(countA + countB);
        }
    }
}
