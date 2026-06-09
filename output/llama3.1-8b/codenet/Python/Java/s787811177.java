import java.util.Arrays;
import java.util.Scanner;

public class s787811177 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] ls = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < 2; j++) {
                ls[i][j] = Integer.parseInt(input[j]);
            }
        }

        Arrays.sort(ls, (a, b) -> Integer.compare(sum(b), sum(a)));

        int taka = 0;
        int aoki = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                taka += ls[i][0];
            } else {
                aoki += ls[i][1];
            }
        }

        System.out.println(taka - aoki);
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}