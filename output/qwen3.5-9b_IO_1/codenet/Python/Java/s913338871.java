import java.util.Scanner;
import java.util.Arrays;

public class s913338871 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        
        int sum = 0;
        for (int i = N - 1; i >= 0; i -= 2) {
            sum += a[i];
        }
        
        System.out.println(sum);
    }
}
