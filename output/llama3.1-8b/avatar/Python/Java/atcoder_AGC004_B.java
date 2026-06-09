import java.util.Scanner;

public class atcoder_AGC004_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);

        int[] a = new int[n];
        String[] line = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            int m = a[i];
            for (int j = 0; j < n; j++) {
                int k = (i - j + n) % n;
                m = Math.min(m, a[k]);
                b[j][i] = m;
            }
        }

        int m = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j : b[i]) {
                sum += j;
            }
            m = Math.min(m, sum + x * i);
        }
        System.out.println(m);
    }
}