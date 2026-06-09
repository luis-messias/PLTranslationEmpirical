import java.util.Scanner;

public class atcoder_ABC148_F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int max_sum = 0;
        int current_sum = 0;

        for (int i = 0; i < n; i++) {
            current_sum += a[i];
            if (current_sum > max_sum) {
                max_sum = current_sum;
            }
            if (current_sum < 0) {
                current_sum = 0;
            }
        }

        System.out.println(max_sum);
    }
}
