import java.util.Scanner;

public class atcoder_ABC136_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long i = 1;
        long ans = 0;
        while (Math.pow(10, i) <= N) {
            ans += ((long)Math.pow(10, i) - (long)Math.pow(10, i - 1));
            i += 2;
        }
        ans += Math.max(0, N - (long)Math.pow(10, i - 1) + 1);
        System.out.println(ans);
    }
}
