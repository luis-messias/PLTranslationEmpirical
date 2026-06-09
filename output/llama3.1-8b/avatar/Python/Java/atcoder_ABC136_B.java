import java.util.Scanner;

public class atcoder_ABC136_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int i = 1;
        int ans = 0;
        while (Math.pow(10, i) <= N) {
            ans += ((int)Math.pow(10, i) - (int)Math.pow(10, i-1));
            i += 2;
        }
        ans += Math.max(0, N - (int)Math.pow(10, i-1) + 1);
        System.out.println(ans);
    }
}