import java.util.Scanner;

public class codeforces_302_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String s = scanner.nextLine();
        int sa = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                sa++;
            }
        }
        sa = Math.min(n - sa, sa);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            input = scanner.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]) - a;
            sb.append((b % 2 == 0 && b <= sa * 2) ? "1\n" : "0\n");
        }
        System.out.println(sb.toString());
    }
}
