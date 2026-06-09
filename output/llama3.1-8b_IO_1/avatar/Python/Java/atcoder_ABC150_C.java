import java.util.Arrays;
import java.util.Scanner;

public class atcoder_ABC150_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long[][] orig = new long[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                orig[i][j] = Integer.parseInt(input[j]);
            }
        }
        long[] p = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] q = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int pn = -1, qn = -1;
        for (int i = 0; i < n; i++) {
            if (Arrays.equals(orig[i], p)) {
                pn = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (Arrays.equals(orig[i], q)) {
                qn = i;
                break;
            }
        }
        System.out.println(Math.abs(pn - qn));
    }
}
