import java.util.Scanner;

public class s906994739 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] F = new int[n][10];
        int[][] P = new int[n][10];

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < 10; j++) {
                F[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < 10; j++) {
                P[i][j] = Integer.parseInt(line[j]);
            }
        }

        int ans = -1000000000;

        for (int i = 1; i <= Math.pow(2, 10); i++) {
            int[] lst = new int[n];
            int tmp = 0;
            for (int j = 0; j < 10; j++) {
                if ((i >> j & 1) == 1) { // opened
                    for (int k = 0; k < n; k++) {
                        lst[k] += F[k][j];
                    }
                }
            }

            for (int k = 0; k < n; k++) {
                tmp += P[k][lst[k]];
            }

            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }
}