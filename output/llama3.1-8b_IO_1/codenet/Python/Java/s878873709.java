import java.util.Scanner;

public class s878873709 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        boolean[] s = {true, true, false, true, false, true, false};
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            if (s[i - 1]) {
                ans = i;
            }
        }

        System.out.println(ans);
    }
}
