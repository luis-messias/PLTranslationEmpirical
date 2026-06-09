import java.util.Scanner;

public class atcoder_ABC154_A {
    public static void solve(String s, String t, int a, int b, String u) {
        if (s.equals(u)) {
            a--;
        }
        if (t.equals(u)) {
            b--;
        }
        System.out.println(a + " " + b);
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        String t = scanner.next();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String u = scanner.next();

        solve(s, t, a, b, u);
    }
}