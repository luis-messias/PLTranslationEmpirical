import java.util.Scanner;
import java.util.Arrays;

public class s246280701 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(input[i]);
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            long tmp = 0;
            for (int j = 0; j < n; j++) {
                tmp += Math.pow(Math.abs(i - x[j]), 2);
            }
            if (tmp < ans) {
                ans = tmp;
            }
        }
        System.out.println(ans);
    }
}