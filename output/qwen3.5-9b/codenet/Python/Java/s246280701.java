import java.util.Scanner;

public class s246280701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        long ans = 10000000000L; // 10^10
        for (int i = 0; i <= 100; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum += (long)(i - x[j]) * (i - x[j]);
            }
            if (sum < ans) {
                ans = sum;
            }
        }
        System.out.println(ans);
    }
}