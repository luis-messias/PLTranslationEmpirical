import java.util.Scanner;

public class codeforces_569_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read t, s, q from a single line of input
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            int s = scanner.nextInt();
            int q = scanner.nextInt();

            int ans = 0;
            while (s < t) {
                s *= q;
                ans++;
            }
            System.out.println(ans);
        }
        scanner.close();
    }
}