import java.util.Scanner;

public class codeforces_154_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String x = scanner.nextLine();
            int a = 0, b = 0;
            for (char j : s.toCharArray()) {
                if (j == x.charAt(0)) {
                    a++;
                } else if (j == x.charAt(1)) {
                    b++;
                } else {
                    ans += Math.min(a, b);
                    a = 0;
                    b = 0;
                }
            }
            ans += Math.min(a, b);
        }
        System.out.println(ans);
    }
}