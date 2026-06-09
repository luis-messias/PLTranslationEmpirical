import java.util.Scanner;

public class atcoder_ABC172_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += i * (N / i) * ((N / i) + 1) / 2;
        }
        System.out.println(ans);
    }
}