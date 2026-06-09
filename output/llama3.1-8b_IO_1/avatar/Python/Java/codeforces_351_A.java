import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class codeforces_351_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        float[] arr = new float[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Float.parseFloat(input[i]);
        }
        Arrays.sort(arr, Comparator.comparingFloat(a -> a - (int) a));
        int o = 2 * n - arr.length;
        float arrSum = 0;
        for (float x : arr) {
            arrSum += x;
        }
        float res = Float.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            if (i + o >= n) {
                res = Math.min(res, Math.abs(i - arrSum));
            }
        }
        System.out.printf("%.3f%n", res);
    }
}
