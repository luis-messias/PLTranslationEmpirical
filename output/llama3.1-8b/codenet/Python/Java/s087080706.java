import java.util.Arrays;
import java.util.Scanner;

public class s087080706 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int i = Arrays.binarySearch(a, x);
        if (i < 0) {
            i = -i - 1;
        }
        System.out.println(Math.min(i, n - i));
    }
}