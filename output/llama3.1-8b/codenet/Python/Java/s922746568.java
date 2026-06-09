import java.util.Scanner;

public class s922746568 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();

        int r_cnt = countChar(s, 'R');
        int g_cnt = countChar(s, 'G');
        int b_cnt = countChar(s, 'B');

        long ans = (long) r_cnt * g_cnt * b_cnt;

        for (int i = 0; i < n; i++) {
            for (int d = 1; i + d < n && i + 2 * d < n; d++) {
                int j = i + d;
                int k = j + d;
                if (s.charAt(i) != s.charAt(j) && s.charAt(j) != s.charAt(k) && s.charAt(k) != s.charAt(i)) {
                    ans--;
                }
            }
        }

        System.out.println(ans);
    }

    private static int countChar(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}