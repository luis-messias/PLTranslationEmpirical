import java.util.Scanner;

public class s636719275 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= s.length() - t.length(); i++) {
            if (check(s.substring(i, s.length()), t)) {
                ans = Math.min(ans, check(t, s.substring(0, i)));
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static int check(String a, String b) {
        int count = 0;
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
